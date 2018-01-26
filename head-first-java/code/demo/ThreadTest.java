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
        // one和two拿到的钱每次都不相同侧面印证了java虚拟机的调度器不是公平，线程的执行顺序和时间不相同
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
