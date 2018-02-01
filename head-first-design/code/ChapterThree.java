// 装饰者和被装饰者的超类
abstract class Beverage {
  String description = "Unknown Beverage";

  public String getDescription() {
    return description;
  }

  public abstract double cost();
}

// 一类装饰者的抽象类
abstract class CondimentDecorator extends Beverage {
  public abstract String getDescription();
}

// 具体被装饰者
class Espresso extends Beverage {
  public Espresso() {
    description = "Espresso";
  }

  public double cost() {
    return 1.99;
  }
}

// 具体装饰者
class Mocha extends CondimentDecorator {
  // 记录被装饰者
  Beverage beverage;

  public Mocha(Beverage beverage) {
    this.beverage = beverage;
  }

  public String getDescription() {
    return beverage.getDescription() + ", Mocha";
  }

  public double cost() {
    return .20 + beverage.cost();
  }
}

public class ChapterThree {
  public static void main(String[] args) {
    Beverage espresso = new Espresso();

    // 用装饰者包裹被装饰对象
    Beverage mocha = new Mocha(espresso);

    System.out.println(mocha.getDescription() + " " + mocha.cost());
  }
}