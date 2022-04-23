package buzz.yixiaobai.thread.demo01;

/**
 * 创建线程方式2：实现Runnable接口，重写run()方法，执行线程需要丢入Runnable接口实现类，调用start()方法
 * @author yixiaobai
 * @create 2022/04/22 下午8:25
 */
public class TestRunnable01 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args){
        // 创建一个线程对象
        TestRunnable01 test01 = new TestRunnable01();
        // 实现Runnable接口的方法，需要将类传入Thread方法中，并调用start()方法
        new Thread(test01).start();
        for(int i = 0; i < 20; i++){
            System.out.println("我在学习多线程--" + i);
        }
    }
}
