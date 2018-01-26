/**
 * 构造函数
 */

class Animal {
  public Animal() {
    System.out.println("I am animal class");
  }

  public Animal(int old) {
    System.out.println("I am animal class which " + old + " years old");
  }
}

class Duck extends Animal {
  int size;

  // 这是个构造函数，会在实例化前调用
  public Duck(int argSize) {
    // 编译器会自动调用无参数的父类构造函数
    // 手动添加的话一定要放在第一行
    super();

    System.out.println("I am a fucking duck");

    // 构造函数用法之一，可以为实例变量设计初始值
    size = argSize;
  }

  // 如果程序员不知道或者忘记了设置size值怎么办？
  // 可以用重载的思路设定一个不需要参数的狗爪函数
  public Duck() {
    // 调用存在参数的父类构造函数
    super(20);

    size = 28;
  }

  public Duck(Boolean isDuck) {
    // this()表示调用相同类中的其他构造函数，用参数个数和类型决定调用哪一个
    this();
  }

  int getSize() {
    return size;
  }
}

public class ConstructorTest {
  public static void main(String[] args) {
    // I am animal class
    // I am a fucking duck
    Duck duck = new Duck(20);
    System.out.println(duck.getSize()); // 20

    Duck duck2 = new Duck(); // I am animal class which 20 old
    System.out.println(duck2.getSize()); // 28

    Duck duck3 = new Duck(true); // I am animal class which 20 old
  }
}