package buzz.yixiaobai.thread.demo02;

/**
 * @author yixiaobai
 * @create 2022/04/22 下午9:18
 */
public class TestThread01 implements Runnable{
    // 票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while(true){
            if(ticketNums <= 0){
                break;
            }

            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums--+ "票");
        }
    }

    public static void main(String[] args){
        TestThread01 thread01 = new TestThread01();
        new Thread(thread01, "小明").start();
        new Thread(thread01, "老师").start();
        new Thread(thread01, "黄牛党").start();
        new Thread(thread01, "黄牛党").start();
        new Thread(thread01, "黄牛党").start();
        new Thread(thread01, "黄牛党").start();
        new Thread(thread01, "黄牛党").start();
    }
}
