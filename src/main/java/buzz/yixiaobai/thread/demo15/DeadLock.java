package buzz.yixiaobai.thread.demo15;

/**
 * 死锁：多个线程互相抱着对方需要的资源，形成僵持
 * @author yixiaobai
 * @create 2022/04/24 下午11:16
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "灰姑娘");
        Makeup g2 = new Makeup(1, "白雪公主");
        new Thread(g1).start();
        new Thread(g2).start();
    }
}

/**
 * 口红
 */
class Lipstick {

}

/**
 * 镜子
 */
class Mirror {

}

class Makeup extends Thread {

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    // 选择
    int choice;
    // 使用化妆品的人
    String girlName;

    Makeup(int choice, String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run(){
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 化妆，互相持有对方的锁，就是需要拿到对方的资源
     */
    private void makeup() throws InterruptedException {
        if( choice == 0){
            // 获取到口红的锁
            synchronized (lipstick) {
                System.out.println(Thread.currentThread().getName() + "正在使用口红！");
                Thread.sleep(1000);
                synchronized (mirror){
                    System.out.println(Thread.currentThread().getName() + "正在使用镜子！");
                }
            }
        }else{
            synchronized (mirror){
                System.out.println(Thread.currentThread().getName() + "正在使用镜子！");
                Thread.sleep(1000);
                synchronized (lipstick) {
                    System.out.println(Thread.currentThread().getName() + "正在使用口红！");
                }
            }
        }
    }
}
