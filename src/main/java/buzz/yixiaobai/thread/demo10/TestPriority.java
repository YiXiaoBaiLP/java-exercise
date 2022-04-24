package buzz.yixiaobai.thread.demo10;

/**
 * @author yixiaobai
 * @create 2022/04/24 下午1:22
 */
public class TestPriority {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName() + "--> 主线程的优先级为：" + Thread.currentThread().getPriority());


        Thread t1 = getThread();
        Thread t2 = getThread();
        Thread t3 = getThread();
        Thread t4 = getThread();
        Thread t5 = getThread();
        Thread t6 = getThread();

        // 设置线程的优先级
        t1.setPriority(2);
        t1.start();

        t6.start();

        t3.setPriority(5);
        t3.start();

        t4.setPriority(7);
        t4.start();

        t5.setPriority(3);
        t5.start();

        t2.setPriority(10);
        t2.start();
    }

    public static Thread getThread(){
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "--> 线程的优先级为：" + Thread.currentThread().getPriority());
        });
    return thread;
    }
}
