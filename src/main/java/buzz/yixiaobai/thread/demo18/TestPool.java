package buzz.yixiaobai.thread.demo18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试线程池
 * @author yixiaobai
 * @create 2022/04/26 上午11:15
 */
public class TestPool {
    public static void main(String[] args) {
        // 创建服务，创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 使用execute方法，执行 Runnable接口
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        // 关闭链接
        service.shutdown();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
