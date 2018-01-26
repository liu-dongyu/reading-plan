class Duck {
  // throws Exception表示这个方法有可能抛出错误
  // 引用方必须try catch或者throws Exception
  int sound() throws Exception {
    int a = 10 / 0;
    return a;
  }
}

public class ErrorHandleTest {
  // main函数不能throws Exception，否则会导致程序死亡
  public static void main(String[] args) {
    try {
      Duck duck = new Duck();
      duck.sound();
      System.out.println("Nobody can see me");
    }  catch (ArithmeticException ex) {
      // ArithmeticException必须写在Exception前面
      // 由于从上至下触发，同类错误要从小写到大
      ex.printStackTrace();
    } catch (Exception ex) {
       // 输出详细的错误信息
      ex.printStackTrace(); 
    } finally {
      System.out.println("Any can see me");
    }
  }
}
