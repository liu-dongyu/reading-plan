// 设定接口
interface Pets {
  // public&abstract 可不写，默认
  public abstract void play();
}

class Animal {
  void eat() {
  }
}

// implements表示继承接口，可以继承多个，以,分割
class Dog extends Animal implements Pets {
  public void play() {
    System.out.println("Dog is playing");
  }
}

class Cat extends Animal implements Pets {
  public void play() {
    System.out.println("Cat is playing");
  }
}

class Fun {
  void start(Pets pet) {
    pet.play();
  }
}

public class InterfaceTest {
  public static void main(String[] args) {
    Dog Husky = new Dog();
    Cat Persian = new Cat();
    Fun play = new Fun();

    // 多态的运用手段
    play.start(Husky); // Dog is playing
    play.start(Persian); // Cat is playing
  }
}