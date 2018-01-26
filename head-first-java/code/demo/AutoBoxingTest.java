/**
 * 包装类型和主数据类型间的转换
 */

import java.util.ArrayList;

public class AutoBoxingTest {
  static int doNumsOldWay() {
    ArrayList<Object> listOfNums = new ArrayList<Object>();
    // java5.0前，ArrayList只能接受和返回object，数字需要手动包装才能保存
    listOfNums.add(new Integer(3));
    Integer one = (Integer) listOfNums.get(0);
    return one.intValue();
  }

  static int doNumsNewWay() {
    ArrayList<Object> listOfNums = new ArrayList<Object>();
    // java5.0后，ArrayList会自动将主数据类型转化为object
    listOfNums.add(4);
    int one = (Integer) listOfNums.get(0);
    return one;
  }

  // 参数是包装类型Integer，则表示可以传递Integer类型，也可以返回int
  static int takeNumbers(Integer i) {
    // 不管是包装类型Integer还是主数据类型int，都可以直接进行数值计算
    return i + 1;
  }

  public static void main(String[] args) {
    System.out.println(doNumsOldWay()); // 3
    System.out.println(doNumsNewWay()); // 4
    System.out.println(takeNumbers(new Integer(4))); // 5
    System.out.println(takeNumbers(5)); // 6

    // 无论是包装类型Boolean还是主数据类型boolean，都可以直接用于条件判断
    Boolean imTrue = new Boolean(4 > 2);
    boolean imTrue1 = 4 > 2;
    if (imTrue && imTrue1) {
      System.out.println("Hello"); // Hello
    }

    // 包装类型和主数据类型可以和相应的包装类型和主数据类型相互赋值
    Integer num = new Integer(3);
    int num1 = num;
    Integer num2 = num1;
    System.out.println(num); // 3
    System.out.println(num1); // 3 
    System.out.println(num2); // 3
  }
}