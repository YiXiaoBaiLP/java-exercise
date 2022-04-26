package buzz.yixiaobai.thread.demo15;

/**
 * 解决死锁
 * @author yixiaobai
 * @create 2022/04/25 下午3:55
 */
public class UnDeadLock {
    public static void main(String[] args) {
        new Makeup02(0, "灰姑娘").start();
        new Makeup02(1, "白雪公主").start();
    }
}
/**
 * 口红
 */
class Lipstick02 {

}

/**
 * 镜子
 */
class Mirror02 {

}

class Makeup02 extends Thread {
    static Lipstick02 lipstick02 = new Lipstick02();
    static Mirror02 mirror02 = new Mirror02();

    // 选择
    private int choice;
    // 使用化妆品的人
    private String girlName;

    Makeup02(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        makeup();
    }

    public void makeup() {
        if(choice == 0){
            synchronized (lipstick02) {
                System.out.println(Thread.currentThread().getName() + "正在使用口红！");
            }
            synchronized (mirror02) {
                System.out.println(Thread.currentThread().getName() + "正在使用镜子！");
            }
        } else {
            synchronized(mirror02) {
                System.out.println(Thread.currentThread().getName() + "正在使用镜子！");
            }
            synchronized(lipstick02) {
                System.out.println(Thread.currentThread().getName() + "正在使用口红！");
            }
        }
    }
}
