// 父类
class Animal {
  private int old;

  void eat() {
    System.out.println("all animal need eat");
  }

  public int getOld() {
    return old;
  }

  // private是私有权限，该方法不会被子类继承
  private void DogIsStuped() {
    System.out.println("dog is stuped,but nobody konw");
  }

  // final表示该方法不可以被子类重写，若写在class前，则表示整个类的所有方法都不能被覆盖
  final void liveInEarth() {
    System.out.println("all animal live in earth");
  }
}

// 子类，Dog类继承了Animal类，拥有所有非私有实例变量和方法
class Dog extends Animal {
  int old = 10;

  void eat() {
    // 运行父类的eat方法
    super.eat();

    System.out.println("dog eat meat");
  }

  // 子类eat方法和父类eat方法不相同，所有没有继承父类的方法。该方法称之为重载
  void eat(String food) {
    System.out.println("dog eat " + food);
  }
}

public class ExtendTest {
  public static void main(String[] args) {
    Dog Dog = new Dog();
    Dog.eat(); // all animal live in earth /n dog eat meat
    Dog.eat("shit"); // dog eat shit
    Dog.liveInEarth(); // all animal live in earth

    // Dog类中的实例便利old不会覆盖父类Animal的old
    System.out.println(Dog.old); // 10
    System.out.println(Dog.getOld()); // 0
  }
}