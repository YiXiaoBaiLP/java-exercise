package buzz.yixiaobai.thread.demo08;

/**
 * 测试join方法：想象为插队
 * @author yixiaobai
 * @create 2022/04/23 下午7:27
 */
public class TestJoin implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin, "我是VIP线程");
        thread.start();

        for(int i = 0; i < 100; i++){
            if(i == 20){
                thread.join();
            }
            System.out.println("main" + i);
        }
    }
}
