package buzz.yixiaobai.thread.demo06;

/**
 * 模拟延时：放大问题的发生性
 * @author yixiaobai
 * @create 2022/04/23 下午6:31
 */
public class TestSleep implements Runnable{

    // 票数
    private int ticketNums = 10;


    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(ticketNums <= 0){
                break;
            }

            System.out.println(Thread.currentThread().getName() + "->拿到了第" + ticketNums-- + "票！");
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        new Thread(testSleep, "线程一").start();
        new Thread(testSleep, "线程二").start();
        new Thread(testSleep, "线程三").start();
        new Thread(testSleep, "线程四").start();

    }
}
