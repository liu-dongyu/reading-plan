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