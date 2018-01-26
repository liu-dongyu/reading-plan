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