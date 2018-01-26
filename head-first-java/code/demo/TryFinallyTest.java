/**
 * 输出结果：ABAB
 * 
 * 执行顺序分析
 * 1. System.out.println(test())， 将test方法推到栈顶并运行
 * 2. System.out.println("A") 输出A
 * 3. s = "A" 将A字符串赋值给s变量
 * 4. return s 程序新增临时变量c，s赋值给c，由于下文存在finally操作，return先不做返回操作
 * 5. System.out.println("B") 输出B
 * 6. s = "B" 将字符串B赋值给s
 * 7. test方法返回变量c的值"A"然后被GC回收
 * 8. System.out.println(test()) 相当于 System.out.println("A") 输出A
 * 9. System.out.println(s) 输出B
 */
public class TryFinallyTest {
  static String s = "A";

  public static void main(String[] args) {
    System.out.println(test());
    System.out.println(s);
  }

  private static String test() {
    try {
      System.out.println("A");
      s = "A";
      return s;
    } finally {
      System.out.println("B");
      s = "B";
    }
  }
}