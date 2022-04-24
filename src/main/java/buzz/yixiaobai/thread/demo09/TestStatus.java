package buzz.yixiaobai.thread.demo09;

/**
 * 线程状态
 * @author yixiaobai
 * @create 2022/04/23 下午8:04
 */
public class TestStatus{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
                for(int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("------------------");
        });
        // 观测线程的五大的五大状态
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        while(thread.getState() != Thread.State.TERMINATED){
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }

        // 死亡之后的线程不能再次执行
        thread.start();

    }
}
