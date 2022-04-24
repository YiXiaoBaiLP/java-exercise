package buzz.yixiaobai.thread.demo12.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全的集合
 * @author yixiaobai
 * @create 2022/04/24 下午4:34
 */
public class UnsafeList {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        for(int i = 0; i < 10000; i++){
            new Thread(() -> {
                // 将线程的名称保存到ArrayList集合中
                strList.add(Thread.currentThread().getName());
            }).start();
        }

        // 我们查看集合中有多少个元素
        System.out.println(strList.size());
    }
}
