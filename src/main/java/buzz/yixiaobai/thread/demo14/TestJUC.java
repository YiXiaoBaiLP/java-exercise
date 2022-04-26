package buzz.yixiaobai.thread.demo14;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * JUC
 * @author yixiaobai
 * @create 2022/04/24 下午7:50
 */
public class TestJUC {
    public static void main(String[] args){
        // 线程安全的ArrayList集合
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for(int i = 0; i < 10000; i++){
            new Thread(() -> copyOnWriteArrayList.add(Thread.currentThread().getName())).start();
        }

        System.out.println(copyOnWriteArrayList.size());
    }
}
