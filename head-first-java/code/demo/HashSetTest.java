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