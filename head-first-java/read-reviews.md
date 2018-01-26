## 第一章

> 本章主要讲解 java 的一些基本语法 while,if-else,int,string[]等，内容过于基础，有其他语言编程经验者基本可以略过。

#### 知识点：

* .java 由编译器编译出.class 二进制文件，再通过 java 虚拟机运行

```
javac a.java

java a.class or java a
```

* `init x = (int) 24.6`，可以进行类型转化
* `System.out.println` 换行输出，`System.out.print` 同行输出

---

## 第二章

> 本章主要简单的讲解了面向对象和面向过程的差异点，以及表明 java 是纯粹的面向对象语言，基于抽象的类和实际的对象。

#### 知识点：

1. 面向对象的好处之一是具备高度的可拓展性，面对新的需求可能通过新建类来实现，不需要改动原来的代码
2. 当不同的类具备相同的方法时候，可将公用方法设置在父类中，子类继承父类的方法，也可以在子类中重新父类的方法
3. 类是抽象的具有群体意义的事物，而对象是基于类创建出来的具体事物，例如狗是类，而哈士奇就是对象
4. main 函数执行期是不同的对象相互调用等，而不是方法过程

---

## 第三章

> 本章主要讲解了变量有两种数据类型，一种是主数据类型，例如 int,long,btye 等，不同的数据类型大小不一样，不同数据类型不能混用。一种是引用，变量引用是自定义的类创建出来的对象

| 数据类型 | 最大值                | 最小值               |
| -------- | --------------------- | -------------------- |
| int      | 2^31 - 1 (2147483647) | -2^31 (-2147483648)  |
| byte     | 128                   | -128                 |
| short    | 32,767                | -32,768              |
| long     | -263                  | 263-1                |
| char     | \u0000(空格)          | \uffff(65536 个字符) |

#### 知识点：

1. 主数据类型（int）等，相当于创建了一个有容量限制的杯子，再往内填充值
2. `Dog Husky`; 由于变量 Husky 没有指向任何对象，故而是 null
3. `Dog Husky = new Dog()`; `new Dog()`会在内存中单独开辟一个空间存放，Husky 并没有保存该对象的方法和值，只是相当于一个遥控器，可以使用对应对象的功能
4. `Dog Husky = new Dog()`; 每次使用该语句都会在内存开辟空间，保证了即便实例化了同一个类，也会彼此相互独立，互不影响，但有可能会浪费内存

---

## 第四章

```java
// 参数传递是拷贝传递，在函数内修改了传入参数，原传入值不变
class test {
  int haha(int arg) {
    arg = 1;
    return 1;
  }
}

int d = 23;
Test t = new Test();

print(t.haha(d)); // 1
print(d); // 23
```

```java
class test {
  // t是实例变量，存在默认值0
  int t;
  void getDemo() {
    // a是局部变量，没有默认值，直接调用会编译出错
    int a;
    // a没有附值，这里会编译错误
    int b = a + 10;
  }
}
```

```java
// 获取和设置实例变量时都推荐使用getter和setter函数，方便拓展以及参数错误校验等
class test {
  int demo = 0;

  // getter函数
  int getDemo() {
    return demo;
  }

  // setter函数
  void setDemo(x) {
    demo = x;
  }
}
```

```java
// 可以使用 == 作为主数据类型变量是否相等的判断
int a = 1;
int b = 1;
a == b; // true

// 引用变量类型也可以使用 == 进行判断，但仅能判断是否引用了同一个对象，不能判断对象是否相等
Dog ha = new Dog();
Dog ka = new Dog();
Dog wa = ha;

ha == wa; // true
ha == ka; // false
ka == wa; // false
```

---

## 第五章

本章主要通过一个小游戏，描述了编写程序的过程

1. 高层设计，熟悉程序流程，画出流程图，设计需要的类
2. 编写伪码，梳理每个类该做什么，主程序该做什么，不考虑功能是否能实现，只关心逻辑
3. 根据伪码编写测试代码，以测试驱动开发
4. 编写真正的 java 代码

```java
// 一些新出现的语法

// array：数组，cell：数组的某一项，必须匹配类型
for(int cell: array)

// 将字符串转为数字，仅能转类似’3’，其他类型的例如’a’会报错
Integer.parseInt(‘3’)

// 获取随机数，0 - 1
Math.random()
// 获取0-4随机数
int ran = (int)(Math.random() * 5);
```

---

## 第六章

> 本章继续通过对小游戏的优化，提出了 java 存在自己的函数库，可以直接当做组件来使用，其中重点描述了`ArrayList`

#### 知识点：

1. 使用`import`不会使得程序变大或者变慢，只是为了不用每次都写全包名称
2. `ArrayList`只能存放对象，即使使用的是主数据类型`int`等，`ArrayList`也会将其包装成对象保存
3. `System，String`等存在于`java.lang` 中，而`java.lang` 默认引入，所以不需要在头部`import`

```java
// 申明将要使用ArrayList类
import java.util.ArrayList;

class Egg {}

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
    int hit =  myList.indexOf(s);

    System.out.println(hit); // 0
    System.out.println(size); // 2
    System.out.println(isIn); // true

    // 删除某个元素，数组长度会缩小
    myList.remove(s);

    size = myList.size();
    isIn = myList.contains(s);
    hit =  myList.indexOf(s);

    System.out.println(hit); // -1
    System.out.println(size); // 1
    System.out.println(isIn); // false
  }
}
```

---

## 第 7 章

> 本章主要描述了如何设计与实现继承以及相关注意事项，并粗略讲解了多态。

#### 知识点：

1. 父类是抽象的，例如动物，子类是具体的事物，例如猫
2. java 虚拟机会从下到上寻找对应的方法，先找自己没有在找父类
3. 判断父子类是否合乎逻辑可以使用 IS-A 测试，例如猫是动物（正确），例如澡盆是浴室（错误）
4. 子类是父类 `extends` 出来的
5. 子类会继承父类所有 `pulic` 类型的实例变量和方法，但不会继承 `private` 类型相关
6. 继承的方法可以覆盖，但实例变量不会被覆盖
7. 方法覆盖的约定
   * 参数一样，返回类型一致
   * 方法的权限不能变更

```java
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
    System.out.println("dog is stuped,but nobody know");
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
```

---

## 第 8 章

> 本章主要讲解多态的使用场景和注意事项以及抽象类和具体类的差异，在通过多重继承问题引出接口（interface）

#### 要如何判断应该设计类，子类，抽象类或者接口？

1. 如果新的类无法对其他类通过 IS-a 测试，就设计不继承该类
2. 在某类需要特殊版本的时候，用覆盖或者新增方法来继承类
3. 当需要定义一群模版，又不希望其他人初始化，可以设计抽象类
4. 多重继承或者设计某个类可以扮演的角色时候，可用接口

|                                | 抽象类 | 具体类 |
| ------------------------------ | ------ | ------ |
| 能否用 new 实例化              | 否     | 是     |
| 能否存在抽象方法               | 是     | 否     |
| 是否需要覆盖所有父类的抽象方法 | 否     | 是     |
| 是否具备实际意义或者具体事物   | 否     | 是     |

#### 多态

* 可以申明一个父类类型的变量，指向子类对象 `Animal Husky = new Dog()`，但 Husky 仅能使用 Animal 以及 Animal 父类的实例变量和方法
* 可以使用父类定义函数参数，然后传递子类进去

```java
   void someFunc(Animal ani){}
   Dog Husky = new Dog();
   someFunc(Husky)
```

* 可以申明一个父类数组，而后保存子类变量，同理，`animals[0]／animals[1]`只能使用 `Animal`以及 `Animal` 父类的实例变量和方法

```java
Animal[] animals = new Animal[2];
animals[0] = new Dog();
animals[1] = new Cat();
```

```java
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
```

```java
// 设定接口
interface Pets {
  // public&abstract 可不写，默认
  public abstract void play();
}

class Animal {
  void eat() {}
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
```

---

## 第九章

> java 中内存存在两种区域，对象的生存空间堆（heap），方法调用和变量的生存空间栈（stack），内存的大小取决于 java 虚拟机和平台的版本。当某个方法被调用时，该方法会被移动到栈顶，栈块存在所有方法的状态以及程序执行到哪和 所有局部变量

#### 构造函数知识点

1. `Dog husky = new Dog()`; `Dog()`实际为构造函数，构造函数默认由编译器添加
2. 构造函数必须与类同名且无返回类型，只要存在一个构造函数（无论有无参数），编译器都不会再创建
3. 自定义构造函数内的方法会在对象实例化前调用
4. 类允许存在多个不同的构造函数，保持函数名字相同，参数不同即可
5. 构造函数在执行时，会调用父类的构造函数，连锁反应直到 `object` 类，这一过程称之为构造函数链

#### 对象被销毁的时机

1. 声明引用变量的方法执行完毕
2. 引用变量被赋值到别的对象上
3. 将引用变量设置为 null

|          | 实例变量                     | 局部变量                                                                                     |
| -------- | ---------------------------- | -------------------------------------------------------------------------------------------- |
| 生命周期 | 只用对象被销毁的时候才会死亡 | 只存活在声明的方法内，且方法要在栈顶中才能获取，当方法执行完毕栈块回收时，局部变量也会被回收 |
| 存在空间 | 跟随对象存在于堆             | 跟随方法存在于栈                                                                             |

```java
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
```

---

## 第 10 章

* cpu 运行的时候主要需要指令和数据，指令指的是具体的语句和方法等（1 个语句有可能编译为多个 cpu 指令），数据指的是数值和指针

```java
void main {
  int a = 10;
  a ++;
}
```

* 该程序编译成机器码后，虚拟机会将所有的机器码放到栈内执行。`a = 1`0 和 `a ++`相当于两条指令（编译成机器码后不止两条），10 是数值，这些都保存在栈内

```java
void main {
  Class a = new Class();
  a.b ++:
}
```

* 运行 `new Class()`，首先会先在堆中分配空间用来装 `Class` 内的成员变量和方法指针，然后再调用 `Class` 的构造函数，`Class a` 这个临时变量用来记录指向堆空间内 `Class` 的指针，`a.b ++`表示想先通过指针在堆中获取相应的值而后自增

```java
Class a {
  int b;
  Class2 c;
}
```

* a 在堆中储存了数值 b 和指针 c
* `static Class a = new Class();`,静态变量 a 保存在静态区（非堆非栈），存放在静态区的东西永久保久，直到程序终止

```java
Class a {
  static int b = 10;
  static Class2 c;
}
```

* a 和 b 虽然是 a 的实例变量，但由于设定为静态，故而不会保存在堆中，会存在于静态区，通过类名获取相应的，例如 a.b a.c
* 每个 java 程序都有 1 个 main 函数，静态区相当于在 main 函数外定义变量，有点类似 c++的全局变量，所以可以存活到程序终止

#### Math 方法一览

1. `Math.random()`，返回一个介于 0.0-1.0 之间的双精度浮点数
2. `Math.abs()`，返回双精度浮点数或整数的绝对值
3. `Math.round()`，浮点数 4 舍 5 入返回整型或长整型
4. `Math.min()`，返回两参数较小的数字，参数可以是 int,long,float,double
5. `Math.max()`，返回两参数较大的数字，参数可以是 int,long,float,double

### 静态方法 vs 非静态方法

* 调用方式
  * 以类名调用静态方法（以引用变量名调用也可以，但不推荐，容易混淆）
  * 以引用变量名调用非静态方法
* 内存占用情况
  * 静态可以直接通过类调用，无需实例化对象，所以静态方法只存在于栈，堆中没有相应的对象
  * 非静态方法需要实例化才能使用，方法占用栈空间，对象占用堆空间
* 数据共享
  * 同类的不同对象共享静态变量
  * 不同引用变量指向不同对象，不同对象数据独立，互不干扰
* 静态方法不能调用非静态的实例变量，因为堆上没有相应的对象，同理，也不能调用非静态方法。非静态方法也能够以引用变量名调用，但依旧遵循以上原则

```java
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
```

```java
/**
 * 包装类型和主数据类型间的转换
 */

import java.util.ArrayList;

public class AutoBoxingTest {
  static int doNumsOldWay() {
    ArrayList<Object> listOfNums = new ArrayList<Object>();
    // java5.0前，ArrayList只能接受和返回object，数字需要手动包装才能保存
    listOfNums.add(new Integer(3));
    Integer one = (Integer) listOfNums.get(0);
    return one.intValue();
}

  static int doNumsNewWay() {
    ArrayList<Object> listOfNums = new ArrayList<Object>();
    // java5.0后，ArrayList会自动将主数据类型转化为object
    listOfNums.add(4);
    int one = (Integer) listOfNums.get(0);
    return one;
}

  // 参数是包装类型Integer，则表示可以传递Integer类型，也可以返回int
  static int takeNumbers(Integer i) {
    // 不管是包装类型Integer还是主数据类型int，都可以直接进行数值计算
    return i + 1;
  }

  public static void main(String[] args) {
    System.out.println(doNumsOldWay()); // 3
    System.out.println(doNumsNewWay()); // 4
    System.out.println(takeNumbers(new Integer(4))); // 5
    System.out.println(takeNumbers(5)); // 6

    // 无论是包装类型Boolean还是主数据类型boolean，都可以直接用于条件判断
    Boolean imTrue = new Boolean(4 > 2);
    boolean imTrue1 = 4 > 2;
    if (imTrue && imTrue1) {
      System.out.println("Hello"); // Hello
    }

    // 包装类型和主数据类型可以和相应的包装类型和主数据类型相互赋值
    Integer num = new Integer(3);
    int num1 = num;
    Integer num2 = num1;
    System.out.println(num); // 3
    System.out.println(num1); // 3
    System.out.println(num2); // 3
  }
}
```

```java
/**
 * java自带的格式化操作
 */
import java.util.Date;

public class FormatTest {
  public static void main(String[] args) {
    // %: 占位符，会被后面的参数替代
    // ,d 表示以十进制整数带有,的方式来来输出
    String a = String.format("%,d", 1000000000);
    System.out.println(a); // 1,000,000,000

    // .2f: 获取小数点后两位
    String b = String.format("%,.2f", 1000000000.12345);
    System.out.println(b); // 1,000,000,000.12

    // 支持多个参数
    // 理论上支持无限个参数，但并不代表有无数个重载方法，这是使用到可变参数列表
    String c = String.format("%,d %,.2f", 1000000000, 1000000000.12345);
    System.out.println(c); // 1,000,000,000 1,000,000,000.12

    Date date = new Date(1515653435);
    // 输出完成的日期时间
    String d = String.format("%tc", date);
    // 输出时间
    String e = String.format("%tr", date);
    // 输出周月日 <表示跟随前一个的参数
    String f = String.format("%tA %<tB %<td", date);
    System.out.println(d); // 星期日 一月 18 21:00:53 CST 1970
    System.out.println(e); // 09:00:53 下午
    System.out.println(f); // 星期日 一月 18
  }
}
```

```java
import java.util.Calendar;

/**
 * 常用方法一览
 *
 * API：
 * add(int field, int mount) 加减时间值
 * get(int field) 取出指定字段的值
 * getInstance() 返回Calendar对象，可指定地区
 * getTimeInMillis() 获取相对于1970年1月1日的微秒数
 * roll(int field, int value) 加减时间值，不进位
 * set(int field, int value) 设定指定字段的值
 * set(int year, int month, int day, int hour, int minute) 设定完整的时间
 * setTimeInMillis(long millis) 以毫秒指定时间
 *
 * 字段：
 * DATE / DAY_OF_MONTH 每月的几号
 * HOUR / HOUR_OF_DAY 小时
 * MIlllSECOHD 毫秒
 * MINUTE 分钟
 * MONTH 月份
 * YEAR 年份
 * ZONE_OFFSET 时区位移
 */

public class CalendarTest {
  public static void main(String[] args) {
    // Calendar是抽象类，不能被实例化
    // Calendar cal = new Calendar();

    // 创建Calendar方法
    Calendar cal = Calendar.getInstance();

    // 将时间设定为1992年2月19日 10:00
    // 月份：0 - 11
    cal.set(1992, 1, 19, 10, 0);

    // 将时间转化为相对于1970年1月1日的微秒数
    long day1 = cal.getTimeInMillis();
    System.out.println(day1);

    // 1秒 = 1000微秒，1小时3600秒
    day1 += 1000 * 60 * 60;
    cal.setTimeInMillis(day1); // 时间增加1小时
    System.out.println("new hour " + cal.get(Calendar.HOUR_OF_DAY));

    // add代表前进35天 2月19日增加35天就是3月25日
    cal.add(Calendar.DATE, 35);
    System.out.println("add 35 days " + String.format("%tc", cal.getTime()));

    // roll代表日向前滚动35，月份不跟随递增
    // 3月25日，25向前滚动35，得出3月29(25 + 35 - 31)日
    cal.roll(Calendar.DATE, 35);
    System.out.println("roll 35 days " + String.format("%tc", cal.getTime()));

    // 设置为当月的1号
    cal.set(Calendar.DATE, 1);
    System.out.println("set to 1 " + String.format("%tc", cal.getTime()));
  }
}
```

---

## 第十一章

```java
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
```

```java
/**
 * 错误处理
 */
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
    } catch (Exception ex) {
      System.out.println("Error happen");
    } catch (ArithmeticException ex) {
      // 由于ArithmeticException是Exception的子类
      // 所有错误都会被Except捕捉，不会在这触发
      // 所以多catch的时候要把子类写在前面
    } finally {
      System.out.println("Any can see me");
    }
  }
}
```

---

## 第 12，13 章均讲解怎么使用 java 编写 gui 界面，略过

---

## 第 14 章

#### 序列化

1. 对象上的所有实例变量以及实例变量指向的对象都会被实例化
2. 整个对象版图，包括实例变量指向的对象，都必须申明可以序列化，否则会编译失败
3. 标记为 `transient` 的实例变量不会被序列化
4. 实例对象引用了同一个对象，则该对象只会序列化 1 次
5. 由于静态变量储存在静态区，不在对象中，所以不会被序列化
6. 对象必须实现序列化接口才能被序列化，一旦父类实现了，则子类默认实现
7. 序列化可以储存对象的状态
8. 使用 `ObjectOutputStream` 来序列化对象
9. 用 `FIleOutputStream` 链接 `ObjectOutputStream` 来将对象序列化到文件上

#### 解序列化

1. 被解序列化的对象会从新配置在堆上，但构造函数不会触发
2. 对象的实例变量会被还原成序列化时的状态值，而 `transient` 类型的会赋值 `null` 或主数据类型的默认值
3. 如果解序列化对象的继承树上有一个不可被序列化的祖先对象，则从该对象起，所有的祖先对象的构造函数都会被初始化，构造函数连锁启动后不可停止
4. 某些操作会使得解开序列化失败
   * 删除类原有的实例变量
   * 改变实例变量的类型
   * 改变类的继承层次
   * 将类的可序列化改为不可序列化
   * 将实例变量改为静态
   * 将非 `transient` 实例变量改为 `transient`
5. 类序列化时，会自动添加一个版本识别 id（serialVersionUID）,解序列话时通过比对该 id，不一致则失败，开发者可以自行将 `serialVersionUID` 放入类中，但一旦如此，就表示要对解序列化时新旧对象不一致问题负全责

```java
/**
 * 序列化和反序列化，将对象保存到文件中
 */

// 文件操作相关类
import java.io.*;

// 必须使用implements Serializable申明该类可以被序列话
class Box implements Serializable {
  private int width;
  private int height;
  // transient表示不需要被序列化
  private transient int old;

  public void setWidth(int arg) {
    width = arg;
  }

  public void setHeight(int arg) {
    height = arg;
  }

  public void setOld(int arg) {
    old = arg;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getOld() {
    return old;
  }
}

class StreamHandle {
  static void close(OutputStream out) {
    try {
    if (out != null) {
      out.close();
    }
    } catch(Exception ex) {
      ex.printStackTrace();
    }
}

  static void close(InputStream out) {
    try {
      if (out != null) {
      out.close();
    }
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
}

public class SerializationTest {
  // 序列化
  public static void outPut() {
    ObjectOutputStream os = null;
    FileOutputStream fs = null;

    try {
      Box box = new Box();
      box.setWidth(10086);
      box.setHeight(10086);
      box.setOld(10086);

      // 打开某个文件，不存在则会重新创建
      fs = new FileOutputStream("foo.ser");
      // 创建序列化输入对象，输出到fs
      os = new ObjectOutputStream(fs);
      // 将数据转化为二进制串流
      os.writeObject(box);

      System.out.println("Output success");
    } catch(Exception ex) {
      ex.printStackTrace();
    } finally {
      // 系统资源有限，必须手动释放，gc不会主动回收
      // 写在finally是保证无论有无错误，系统资源都会得到释放
      StreamHandle.close(fs);
       StreamHandle.close(os);
    }
  }

  // 反序列化
  public static void inPut() {
    FileInputStream fsIn = null;
    ObjectInputStream osIn = null;

    try {
      // 文件如不存在会报错
      fsIn = new FileInputStream("foo.ser");
      osIn = new ObjectInputStream(fsIn);

      // 写入多少个对象就可以read多少次  
      Object ob = osIn.readObject();
      Box box1 = (Box) ob;

      System.out.println("Input success");
      System.out.println(box1.getWidth()); // 10086
      System.out.println(box1.getHeight()); // 10086
      System.out.println(box1.getOld()); // 0

    } catch(Exception ex) {
      ex.printStackTrace();
    } finally {
      StreamHandle.close(fsIn);
      StreamHandle.close(osIn);
    }
  }

  public static void main(String[] args) {
    outPut();
    inPut();
  }
}
```

```java
import java.io.*;

public class IoTest {
  static void base() {
    // File对象只能获取目录名或文件名，不能获取文件中的数据
    File f = new File("txt");

    // 判断是不是目录，是则循环列出目录中的所有文件名
    if (f.isDirectory()) {
      String[] contents = f.list();
      for (int i = 0; i < contents.length; i++) {
        System.out.println(contents[i]);
      }
    }

    // 新建目录
    File dir = new File("txt/newDir");
    dir.mkdir();
    System.out.println(dir.getAbsolutePath()); // 获取绝对路径
    boolean isDel = dir.delete(); // 删除目录或文件
    System.out.println(isDel); // true
  }

  // 缓冲区操作
  static void buffer() {
    BufferedWriter bw = null;
    FileWriter fw = null;
    FileReader fr = null;
    BufferedReader br = null;

    try {
      fw = new FileWriter("txt/test.txt", true);
      bw = new BufferedWriter(fw); // 通过链接缓冲区来进行文件操作
      bw.write("哇哈哈");

      // 表示将缓冲区内容强制写入文件，否则方法执行过程中，文件内容不会变更
      bw.flush();

      fr = new FileReader("txt/test.txt");
      br = new BufferedReader(fr);

      String line = br.readLine();
      System.out.println(line);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (bw != null)
          bw.close();
        if (fw != null)
          fw.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  // 直接读写文件操作
  static void withoutBuffer() {
    FileWriter fw = null;
    FileReader fr = null;

    try {
      // 如果该文件不存在会创建
      // false（默认值）表示覆盖写入，覆盖写入会先自动写入缓冲区，方法执行完毕才会写入文件中
      // true表示在末尾续写，write方法的内容立即被写入文件中
      fw = new FileWriter("txt/test.txt");

      fw.write("哈哈哈哈哈");

      // 表示立即内容写入文件中
      fw.flush();

      // 文件不存在会报错
      fr = new FileReader("txt/test.txt");

      char[] msg = new char[2];
      int len = fr.read(msg, 0, 2); // 取出从第0位到第1位的字符放入msg，返回字符长度或-1

      System.out.println(len); // 2
      System.out.println(msg); // 哈哈

    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try {
        if (fw != null) {
          fw.close();
        }
       if (fr != null) {
         fr.close();
        }
       } catch (Exception ex) {
         ex.printStackTrace();
       }
    }
  }

  public static void main(String[] args) {
    base();
    withoutBuffer();
    buffer();
  }
}
```

---

## 第十五章

#### 知识点

1. 每个服务器上面都有 65536（0-65535）个 tcp 端口，0 ～ 1023 端口号不能使用，保留给已知的服务，例如网页服务器（http）端口是 80，telnet 服务器端口是 23，pop3 邮件服务器端口是 110，smtp 邮局交换服务器端口是 25
2. 不同程序不能共用一个端口，使用已被占用的端口会报 BindException
3. 线程（thread）是独立的执行空间（stack），java 编译器默认不会运行，需要程序员手动启动
4. 除非是多处理器系统，否则动作只是在执行空间快速来回切换，并不是绝对意义的同步发生
5. 线程的状态
   * 通常情况下，线程会在可执行和执行中两种涨台交替，java 虚拟机的线程调度会把线程跳出来运行以及送回去以便让其他线程有运行的机会
   * 调度器（scheduler）会因为某些原因暂时关闭线程，移出可执行状态，例如执行到等待 Socket 输入串流，没有数据读取时，又例如线程调用 sleep 等方法
6. 线程调度器
   * 线程的状态以及运行时间都由于调度器来决定，调度器没有 api，不同 java 虚拟机有不同的行为，线程分配的时间和执行顺序都是不一样的
   * sleep 方法可以保证在 sleep 过程中，线程绝对不会被调用，sleep 方法会抛出 InterruptedExc.ption 错误，而且 sleep 结束之后线程并不是绝对马上执行，一直听从调度器安排

#### 线程的并发问题

1. 当多个线程需要操作同一个对象的时候，有可能出现竞争状态
2. 每个对象都有 1 个锁，锁只作用在同步化的方法上，也就是说锁的不是对象的数据，而是方法
3. 锁会带来性能问题，因为线程会排队等待执行方法
4. 锁有可能带来死锁问题，也就是两个线程的同步化方法都持有双方需要的东西

#### 死锁简例

1. 线程 A 进入 foo 对象设定的同步化方法，sleep
2. 线程 B 进入 bar 对象设定的同步方法，在方法中实例化 foo，并进入 foo 的同步化方法，由于该方法被线程 A 占用，只能等
3. 线程 A 醒来，实例化 bar，尝试进入 bar 的同步方法，用于被线程 B 占用，只能等
4. 线程 AB 都在等对方，触发死锁

```java
import java.io.*;
import java.net.*;

public class Client {
  InputStreamReader streamReader = null;
  BufferedReader br = null;
  Socket s = null;

  public void go() {

    try {
      // s.getInputStream 获取底层串流
      s = new Socket(InetAddress.getLocalHost(), 4242);

      // 底层和高层串流间的桥梁
      streamReader = new InputStreamReader(s.getInputStream());

      // 连接数据串联
      br = new BufferedReader(streamReader);

      String line = br.readLine();

      System.out.println("Msg from server: " + line);
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try {
        if (streamReader != null) {
          streamReader.close();
        }
        if (br != null) {
          br.close();
        }
        if (s != null) {
          s.close();
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    Client client = new Client();
    client.go();
  }
}
```

```java
import java.io.*;
import java.net.*;

public class Server {
  String[] list = { "hello", "world", "fuck eac", "fuck coinegg" };
  ServerSocket ss = null;
  Socket s = null;
  PrintWriter pw = null;

  private String getAdvice() {
    int random = (int) (Math.random() * list.length);
    return list[random];
  }

  public void go() {
    try {
      // 监听4242端口
      ss = new ServerSocket(4242);

      // 无限循环等待客户端请求，仅用于测试
      while (true) {
        // 该方法会停止，直到接收到客户端消息
        s = ss.accept();

        pw = new PrintWriter(s.getOutputStream());

        String advice = getAdvice();
        // 向客户端传递字符串消息
        pw.println(advice);

        // 必须close之后数据才会返回客户端，或者使用pw.flush();强制返回
        pw.close();

        System.out.println("Msg to client: " + advice);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try {
        if (ss != null) {ss.close();}
        if (s != null) {s.close();}
        if (pw != null) {pw.close();}
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    Server ser = new Server();
    ser.go();
  }
}
```

```java
// 需要使用线程的类必须使用Runnable接口
public class ThreadTest implements Runnable {
  private int money = 100;
  private int one = 0;
  private int two = 0;

  // Runnable接口唯一需要覆盖的方法，会在线程执行期间运行
  public void run() {
    while (money != 0) {
      someoneGetMoney();
    }
  }

  // synchronized保证了该方法同一时间只能运行，也就是保证了one和two拿到的钱总额是100
  public synchronized void someoneGetMoney() {
    try {
      String name = Thread.currentThread().getName();
      Thread.sleep(100);
      if (money == 0) {
        // one和two拿到的钱每次都不相同
        // 侧面印证了java虚拟机的调度器不是公平，线程的执行顺序和时间不相同
        System.out.println("钱拿光了" + money);
        System.out.println("threadOne一共拿了：" + one);
        System.out.println("threadTwo一共拿了：" + two);
        return;
      }
      if (name.equals("threadOne")) {
        one = one + 10;
      } else {
        two = two + 10;
      }
        money -= 10;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    System.out.println("wait..");

    ThreadTest threadJob = new ThreadTest();

    // 告诉Thread对象要把threadJob的run方法放到执行空间
    Thread threadOne = new Thread(threadJob);
    Thread threadTwo = new Thread(threadJob);
    threadOne.setName("threadOne");
    threadTwo.setName("threadTwo");
    threadOne.start();
    threadTwo.start();
  }
}
```

---

## 第十六章

#### 范型

1. 可以声明 `arrayList` 等数据结构的传入传出类型，更安全
2. 用于参数化类型

```java
// arrayList源码片段

// E代表集合所要维护和返回的对象
// 比如实例化 ArrayList<Song> song = new ArrayList<Song>();E会被Song替代，Song就是范型，他决定了只能存储和返回Song类型的数据
public class ArrayList<E> extends AbstractList<E> implements List<E> … {
  public boolean add(E e)
}
```

```java
// 表示参数可以是Animal，也可以是继承Animal类的所有子类
// T和?都称作万用字符，效果一致
// 任何使用万用字符的地方，编译器都会阻止一切破坏引用参数集合的行为
// 例如你可以查看list中的元素，但不能增加或删
public <T extend Animal> void takeThing(ArrayList<T> list)
public void takeThing(ArrayList<? extends Animal> list)

// 参数只能是Animal类
// 这里不遵循多态，哪怕dog继承了Animal也无法传递进来，因为dog能做的事不是所有Animal都能做
public void takeThing(Array<Animal> list)
```

#### 对象的相等性

1. 引用相等性，堆上同一对象的两个引用，具备相同的 `hashCode`，可以用`==`进行判断
   `hashCode` 根据内存位置来计算的，一般不会出现重复
2. 对象相等性，引用了堆上两个不同的对象，但对象在意义上是相同的
   `hashCode` 不相同，但 `equals` 返回 true

```java
import java.util.HashSet;

/**
* 如何去重？
* 先通过hashCode比较，若不同则认为他们不相同，若相同则通过equals来判断
*/

class Song {
  private String name;

  Song(String argName) {
    name = argName;
  }

  public String getName() {
    return name;
  }

  // 覆盖原hashCode方法，为了主导hashSet去重的判断
  public int hashCode() {
    return name.hashCode();
  }

  // 覆盖原equals方法，为了主导hashSet去重的判断
  public boolean equals(Object aSong) {
    Song a = (Song) aSong;
     return getName().equals(a.getName());
  }
}

@SuppressWarnings("unchecked")
class HashSetTest {
  public static void main(String[] args) {
    HashSet<Song> set = new HashSet<Song>();
    HashSet<Song> set1 = null;

    Song song1 = new Song("爱的供养");
    Song song2 = new Song("爱的供养");
    Song song3 = new Song("爱的供养");

    System.out.println(set.add(song1)); // true
    System.out.println(set.add(song2)); // false
    System.out.println(set.add(song3)); // false

    // 浅拷贝
    set1 = (HashSet<Song>) set.clone();

    // 删除某个元素
    set.remove(song1);

    // 判断set是否含有某个元素
    System.out.println(set.contains(song1)); // false
  }
}
```

```java
import java.util.TreeSet;
import java.util.Iterator;

/**
 * 知识点：
 * TreeSet天生具备排序功能，会将元素以自然顺序排列
 * Iterator是迭代器，用于遍历集合，最大的好处是不需要知道集合的内容
*/

// 需要排序的话必须继承Comparable接口，否则TreeSet等数据结构不知道怎么进行排序
class Song implements Comparable<Song> {
  private String name;
  private String rating;

  Song(String argName, String argRating) {
    name = argName;
    rating = argRating;
  }

  public String getName() {
    return name;
  }

  // 覆盖Comparable接口的方法，排序时用到的方法
  // 返回值 < 0 表示小于
  // 返回值 = 0 表示等于
  // 返回值 > 0 表示大于
  public int compareTo(Song s) {
    return name.compareTo(s.getName());
  }
}

class TreeSetTest {
  // 抑制编译器发出未经检查或不安全操作提示
  // 不加这个无法对clone之后的值做类型转换
  @SuppressWarnings("unchecked")
  public void one() {
    // Integer或String等实现了comparator，默认按照自然顺序排列
    TreeSet<Integer> set = new TreeSet<Integer>();
    TreeSet<Integer> set2 = new TreeSet<Integer>();
    set2.add(10);
    set.add(5);
    set.add(3);
    set.add(4);
    set.add(1);
    set.add(2);

    set.addAll(set2);

    // 返回大于等于传入值的集合中最小元素，没有则返回null
    System.out.println("ceiling " + set.ceiling(6)); // 10

    // 返回小于等于传入值的集合中最大元素，没有则返回null
    System.out.println("floor " + set.floor(6)); // 5

    // 返回小于给定值的最大元素, 不存在就返回null
    System.out.println("lower " + set.lower(6)); // 5  

    // 返回大于给定值的最小元素，不存在就返回null
    System.out.println("higher " + set.higher(6)); // 10

    // 浅拷贝，拷贝出一个新的实例对象，但实例对象中的引用对象等还是指向同一个地址
    TreeSet<Integer> set3 = (TreeSet<Integer>) set.clone();

    // 判断是否含有某个元素
    System.out.println("contains " + set3.contains(1)); // true

    // 返回第一个元素
    System.out.println("first " + set3.first()); // 1

    // 返回最后一个元素
    System.out.println("last " + set3.last()); // 10

    // 判断元素是否为空
    System.out.println("isEmpty " + set3.isEmpty()); // false

    // 获取并移除第一个元素
    System.out.println("pollFirst " + set3.pollFirst()); // 1

    // 获取并移除最后一个元素
    System.out.println("pollLast " + set3.pollLast()); // 10

    // 移除指定元素
    set3.remove(2);

    // 返回元素个数
    System.out.println("size " + set3.size()); // 3

    // 清空所有元素
    set.clear();

    // 返回降序迭代器
    Iterator<Integer> it = set3.descendingIterator();
    while (it.hasNext()) {
      System.out.print(it.next()); // 543
    }

    // 返回升序迭代器
    Iterator<Integer> it1 = set3.iterator();
    while (it1.hasNext()) {
      System.out.print(it1.next()); // 345
    }

    // 返回包含所有元素的逆序视图
    TreeSet<Integer> set4 = new TreeSet<Integer>();
    set4 = (TreeSet<Integer>) set3.descendingSet();
    System.out.println(set4); // 543

    // 返回小于传入值的所有视图，顺序跟随原视图
    TreeSet<Integer> set5 = new TreeSet<Integer>();
    set5 = (TreeSet<Integer>) set3.headSet(5);
    System.out.println(set5); // 34

    // 返回从to到from的视图，第一个bool默认true，代表包括自己，第二个bool默认false，代表不包括自己  
    // bool必须都设置，或都不设置
    TreeSet<Integer> set6 = new TreeSet<Integer>();
    set6 = (TreeSet<Integer>) set3.subSet(3, false, 5, false);
    System.out.println(set6); // 4

    // 返回大于传入值的视图，bool表示是否包括自己，默认true
    TreeSet<Integer> set7 = new TreeSet<Integer>();
    set7 = (TreeSet<Integer>) set3.tailSet(3);
    System.out.println(set7); // 345
  }

  @SuppressWarnings("unchecked")
  public void two() {
    Song a = null;
    TreeSet<Song> set = new TreeSet<Song>();
    set.add(new Song("听妈妈的话", "杰伦"));
    set.add(new Song("爱的供养", "臭脚"));

    Iterator<Song> it = set.iterator();
    while (it.hasNext()) {  
      a = it.next();
      System.out.print(a.getName());
    }
  }

  public static void main(String[] args) {
    TreeSetTest test = new TreeSetTest();
    test.one();
    test.two();
  }
}
```

---

## 第十七章

#### 部署 java 程序有 3 种方式

1. 完全部署在本机，以独立的的 gui 执行，并以为可执行的 jar 来部署，例如桌面程序
2. 分散到用户本地系统的客户端以及连接到应用程序服务的的服务器部分，例如安卓 app
3. 完全在服务端部署，客户通过浏览器等方式访问，例如 java web

#### 如何将源文件和类文件分开

`javac -d ./classes My.java`，-d 表示类文件存放的目录

#### 创建可执行的 JAR 文件步骤，JAR 由于将一组类文件组合起来形成 1 个文件，方便交付

1. 将所有的类文件放到同一个目录，例如 classes
2. 创建 manifest.txt 来描述哪个类带有 main()方法，该文件的内容如：Main-class: MyApp，注意末尾换行
3. 执行 jar 工具来创建带有所有类和 mainfest 的 JAR 文件 `jar -cvmf manifest.txt app.jar ./classer/*.class`
4. 使用`java -jar app.jar`运行

#### 把类包进包中的好处

1. 放在命名冲突
2. 写出可重用的组建

#### 把类包进包中的步骤

1. 选择包名称，例如 com.headfirstjava.HelloWord，com 和 headfistjava 是目录名称，HelloWord 是类名
2. 将包指令加入类中，例如在 HelloWord.java 的头部添加 package com.headfirstjava
3. 设定和包名称相同的目录结构

---

## 第十八章

分布式计算 RMI，老古董，先不学
