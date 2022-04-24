package buzz.yixiaobai.thread.demo11;

/**
 * 守护线程
 * @author yixiaobai
 * @create 2022/04/24 下午1:54
 */
public class TestDaemon {
    public static void main(String[] args) {
        Thread godThread = new Thread(()->{
            while (true){
                System.out.println("上帝守护着你");
            }
        });

        Thread youThread = new Thread(()->{
            for(int i = 1; i < 36500; i++){
                System.out.println("人生不过三万天，每天要开开心心活着^w^");
            }
        });

        // 设置上帝线程为守护线程，setDaemon()方法默认为false
        godThread.setDaemon(true);
        // 启动上帝线程
        godThread.start();

        // 启动自己的线程
        youThread.start();
    }
}
