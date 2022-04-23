package buzz.yixiaobai.thread.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *  练习Thread、实现多线程同步下载图片
 * @author yixiaobai
 * @create 2022/04/22 下午7:50
 */
public class TestRunnable02 implements Runnable{
    // 网络图片地址
    private String url;
    // 保存的文件名
    private String fileName;

    public TestRunnable02(String url, String fileName){
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run(){
        WebDownloader02 webDownloader = new WebDownloader02();
        webDownloader.downloader(url, fileName);
        System.out.println("下载的文件名称为" + fileName);
    }

    public static void main(String[] args){
        TestThread02 thread1 = new TestThread02("https://th.wallhaven.cc/small/rd/rdyyjm.jpg", "1.jpg");
        TestThread02 thread2 = new TestThread02( "https://th.wallhaven.cc/small/3z/3z32j3.jpg", "2.jpg");
        TestThread02 thread3 = new TestThread02("https://th.wallhaven.cc/small/pk/pkgkkp.jpg", "3.jpg");

        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
    }
}

class WebDownloader02 {

    // 下载方法
    public void downloader(String url, String fileName){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));
        } catch(IOException e){
            e.printStackTrace();
            System.err.println("IO异常，网络图片下载失败！！！");
        }
    }
}
