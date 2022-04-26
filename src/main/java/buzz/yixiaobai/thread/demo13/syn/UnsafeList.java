package buzz.yixiaobai.thread.demo13.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * 同步代码块
 * @author yixiaobai
 * @create 2022/04/24 下午6:56
 */
public class UnsafeList {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        for(int i = 0; i < 10000; i++){
            new Thread(()-> {
                // 将变化的量，加锁使其同步
                synchronized (lists){
                    lists.add(Thread.currentThread().getName());
                }}).start();
            }
        System.out.println(lists.size());
    }
}
