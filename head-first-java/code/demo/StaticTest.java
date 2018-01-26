// final类表示不能被继承
final class NoBodyCanExtend {
}

class Duck {
  // 所有实例化对象共用静态实例对象
  static int times;
  int size = 9;

  // final表示一经创建，任何时候都不能在修改
  final Boolean isAnimal = true;

  public Duck() {
    // 错误：不能修改final的值
    // isAnimal = false; 
    times++;
  }

  static void sound() {
    System.out.println("GaGa");
  }

  static int getSize() {
    // 静态的方法不能调用非静态的实例对象，也不能调用非静态的方法
    // return size;
    // getSize1();
    return 0;
  }

  int getSize1() {
    return size;
  }
}

public class StaticTest {
  public static void main(String[] args) {
    // 类中的静态方法可以直接调用，不需要实例化
    Duck.sound(); // GaGa

    Duck duck = new Duck();
    Duck duck1 = new Duck();

    // class Duck has instantiated 2 times
    System.out.println("class Duck has instantiated " + Duck.times + " times");

    // 静态变量可以存活到程序终结，对象是否gc与其无关
    duck = null;
    duck1 = null;
    System.out.println(Duck.times); // 2
  }
}
