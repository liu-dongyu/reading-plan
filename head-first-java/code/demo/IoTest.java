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
