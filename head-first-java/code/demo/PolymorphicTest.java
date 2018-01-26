// abstract表示抽象类，抽象类不可以通过new实例化，抽象类唯一存在的价值就是被继承
// 没有显式声明extends，则默认继承object类
abstract class Animal {
  // 抽象方法只存在于抽象类中，表明该方法必须要被非抽象子类覆盖。
  // 抽象方法相当于一种协议，所有子类都拥有的方法
  abstract void eat(String name);

  abstract void makeNoise();
}

// 抽象子类不需要覆盖抽象父类的抽象方法
abstract class Canine extends Animal {
  abstract void run(String name);
}

class Cat extends Canine {
  void eat(String name) {
    System.out.println(name + " eat catfood");
  }

  void makeNoise() {
    System.out.println("喵");
  }

  // 非抽象子类必须实现所有抽象父类的抽象方法
  void run(String name) {
    System.out.println(name + " is running");
  }
}

class Dog extends Canine {
  void eat(String name) {
    System.out.println(name + " eat shit");
  }

  void makeNoise() {
    System.out.println("汪");
  }

  void run(String name) {
    System.out.println(name + " is running");
  }
}

public class PolymorphicTest {
  public static void main(String[] args) {
    // 由于animal对象不是具体事物，故而设置为抽象，此处不可以实例化
    // Animal ani = new Animal(); error

    // 多态的手段之一，可能声明一个父类变量，指向子类对象
    // 类型指定为Animal，就只能使用Animal以及所继承的类的方法
    Animal Akita = new Dog();
    Animal Sphynx = new Cat();

    // Husky只能使用Object类的方法
    Object Husky = new Dog();
    // Husky.eat(); wrong
    // Husky.run(); wrong
    // Husky.makeNoise(); wrong

    Dog Labrador = new Dog();
    Labrador.run("Labrador"); // Labrador is running

    // 多态度的好处之一 可以声明一个父类数组，保存不同的子类对象
    Animal[] animals = new Animal[2];
    animals[0] = new Dog();
    animals[1] = new Cat();

    animals[0].eat("Chihuahua"); // Chihuahua eat shit
    animals[1].eat("Persian"); // Persian eat catfood

    Akita.eat("Akita"); // Akita eat shit
    Sphynx.eat("Sphynx"); // Sphynx eat catfood

    // 多态的好处之一，可以将参数类型定义做父类，而后以子类作参数
    showAnimalVoice(Akita); // 汪
    showAnimalVoice(Sphynx); // 喵

    // equals从object类继承得来，用于判断两个对象是否相同
    System.out.println(Akita.equals(Sphynx)); // false

    // getClass从object类继承得来，用于获取变量是从哪里初始化得
    System.out.println(Akita.getClass()); // class Dog

    // hashCode从object类继承得来，可用于获取类的唯一id
    System.out.println(Akita.hashCode()); // ****

    // toString从object类继承得来，用于获取类名，类名后带有随机数
    System.out.println(Akita.toString()); // Dog@*****
  }

  static void showAnimalVoice(Animal ani) {
    ani.makeNoise();
  }
}