### 第一章

> 本章提出了 3 点设计原则，并在此基础上总结出 1 条设计模式（策略模式）

#### 设计原则

* 找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起
* 针对接口编程（针对超类编程），而不是针对实现编程。
* 多用组合，少用继承

#### 原则解读

* 假设某个行为在不同的子类中不尽相同，那么则应当将该行为抽离为行为类，分开容易变更和不容易变更的代码
* 不要将行为具体实现在父类或者子类中（针对实现编程），应该考虑能否动态的给子类添加某个行为（针对接口编程），针对接口编程的关键在于多态，在父类的实例变量中定义行为抽象类或接口，子类实例化时动态的选择行为子类（继承了行为抽象类或接口的类）
* 设计行为抽象类或接口时，应尽可能考虑复用性，不要和某个类强关联
* 两个类结合起来使用，就是组合（composition），使用组合建立的系统具备很大的弹性

#### 策略模式

* 策略模式定义了算法族，分别封装起来，让它们之间可以相互替换，此模式让算法的变化独立于使用算法的客户
* 文中将一组行为类定义为算法族，例如下方代码中的`FlyWithWings`就是算法族的一员
* 实例化对象可以任意选择算法族，在运行时动态改变行为

```java
// 将行为抽离为行为接口，单独定义一个接口是为了可以在Duck类中使用使用多态
interface FlyBehavior {
  public void fly();
}

// 具体行为通过继承行为接口实现，继承行为接口是为了可以使用多态
// 不同的duck可能有不同的飞行行为，所有抽离出来
class FlyWithWings implements FlyBehavior {
  public void fly() {
    System.out.println("I am fly with wings");
  }
}

class Duck {
  // 父类中不需要考虑行为是那个具体事物实现的,由运行时动态决定
  FlyBehavior flyBehavior;

  public void performFly() {
    flyBehavior.fly();
  }

}

class YellowDuck extends Duck {
  YellowDuck(FlyBehavior fb) {
    // 动态设置飞行的行为类，假设以后需要改变为其他飞行类型，也不需要改变类的源码，只需要改变调用方
    flyBehavior = fb;
  }
}

class ChapterOne {
  public static void main(String[] args) {
    Duck yellowDuck = new YellowDuck(new FlyWithWings());
    yellowDuck.performFly();
  }
}
```
