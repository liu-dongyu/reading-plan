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

      /** 序列化 */
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