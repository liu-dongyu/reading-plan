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