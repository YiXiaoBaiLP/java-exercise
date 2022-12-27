package buzz.yixiaobai.thread.demo03;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 线程实现三：实现Callable接口（线程池概念）
 * @author yixiaobai
 * @create 2022/04/23 下午1:58
 */
public class TestCallable implements Callable {
    // 文件URL
    private String url;
    // 文件名称
    private String name;
    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public Boolean call() throws Exception {
        WebDownload webDownload = new WebDownload();
        webDownload.download(url, name);
        System.out.println("文件下载成功，文件名称为：" + name);
        return true;
    }

    public static void main(String[] args) {
        TestCallable thread01 = new TestCallable("https://img.tt98.com/d/file/96kaifa/20190813201810680/832ec84d47.jpg", "1.jpg");
        TestCallable thread02 = new TestCallable("https://th.bing.com/th/id/R.67919a70e82b5e761666a70e1ea75ecc?rik=e4DcvjhYmeAJCg&riu=http%3a%2f%2fimage.yjcf360.com%2fu%2fcms%2fwww%2f202012%2f12085259ra6l.jpg&ehk=jxdQyspC2trf3IYeNizhaTQpSaR3CEA8LaiF%2brwYMrs%3d&risl=&pid=ImgRaw&r=0", "2.jpg");
        TestCallable thread03 = new TestCallable("https://th.bing.com/th/id/R.e47eb5f40f946bc385c9ccae0d3d7009?rik=oDzWt6Ea3CfOzg&riu=http%3a%2f%2fimg.mm4000.com%2ffile%2f2%2f1c%2f6e16c2ee89.jpg&ehk=sC377AD56yfwQ2Hrw7QjPsKd08TnFQaGDb3ITduVL1o%3d&risl=&pid=ImgRaw&r=0", "3.jpg");

        // 创建执行服务，创建一个线程池，大小为3
        ExecutorService ser = Executors.newFixedThreadPool(20);
        // 提交执行
        Future<Boolean> result01 = ser.submit(thread01);
        Future<Boolean> result02 = ser.submit(thread02);
        Future<Boolean> result03 = ser.submit(thread03);
        try {
            // 获取结果
            boolean rs01 = result01.get();
            boolean rs02 = result02.get();
            boolean re03 = result03.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        ser.shutdownNow();
    }
}


class WebDownload {

    /**
     * 下载网络图片到本地
     * @param url
     * @param name
     */
    public void download(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("文件下载失败！！！");
        }
    }
}
