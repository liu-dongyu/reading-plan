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
        if (ss != null) {
          ss.close();
        }
        if (s != null) {
          s.close();
        }
        if (pw != null) {
          pw.close();
        }
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