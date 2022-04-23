package buzz.yixiaobai.thread.demo06;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 模拟倒计时
 * @author yixiaobai
 * @create 2022/04/23 下午6:41
 */
public class TestSleep02 {

    public static void main(String[] args){
        try {
            tenDown();
            currTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟时钟
     */
    public static void currTime() throws InterruptedException {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("hh:mm:ss");

        while(true){

            Thread.sleep(1000);
            System.out.println(LocalTime.now().format(dateFormat));
        }

    }
    /**
     * 模拟倒计时
     */
    public static void tenDown() throws InterruptedException {
        int nums = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(nums--);
            if(nums <= 0){
                break;
            }
        }
    }
}
