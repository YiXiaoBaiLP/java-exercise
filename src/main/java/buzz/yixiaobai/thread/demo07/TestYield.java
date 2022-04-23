package buzz.yixiaobai.thread.demo07;

/**
 * 线程礼让：礼让不一定成功，看CPU心情
 * @author yixiaobai
 * @create 2022/04/23 下午7:00
 */
public class TestYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程执行开始++++++");
        // 线程礼让
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程执行结束------");
    }

    public static void main(String[] args){
        TestYield testYield = new TestYield();
        new Thread(testYield, "我是A线程：").start();
        new Thread(testYield, "我是B线程：").start();
    }
}
