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