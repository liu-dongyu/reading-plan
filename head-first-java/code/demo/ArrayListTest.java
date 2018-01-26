// 申明将要使用ArrayList类
import java.util.ArrayList;

class Egg {
}

public class ArrayListTest {
  public static void main(String[] args) {
    // 创建Egg类型的数组
    ArrayList<Egg> myList = new ArrayList<Egg>();
    Egg s = new Egg();
    Egg b = new Egg();

    // 自动在myList增加s和b变量
    myList.add(s);
    myList.add(b);

    // 获取数组大小
    int size = myList.size();

    // 判断某个元素是否存在
    boolean isIn = myList.contains(s);

    // 寻找s变量所在的位置，从0开始，不存在则返回-1
    int hit = myList.indexOf(s);

    System.out.println(hit); // 0
    System.out.println(size); // 2
    System.out.println(isIn); // true

    // 删除某个元素，数组长度会缩小
    myList.remove(s);

    size = myList.size();
    isIn = myList.contains(s);
    hit = myList.indexOf(s);

    System.out.println(hit); // -1
    System.out.println(size); // 1
    System.out.println(isIn); // false
  }
}