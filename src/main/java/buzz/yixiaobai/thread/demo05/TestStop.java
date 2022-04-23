package buzz.yixiaobai.thread.demo05;

/**
 * 停止线程
 * 1、建议线程正常停止--- 利用次数，不建议死循环
 * 2、建议使用标志位---设置一个标志位
 * 3、不建议使用stop()或者destroy()等过时或者JDK不推荐的方法
 * @author yixiaobai
 * @create 2022/04/23 下午4:53
 */
public class TestStop implements Runnable{
    // 设置一个标志位
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("run...Thread"+ i++);
        }
    }

    /**
     * 设置一个公开方法停止线程，转换标志位
     */
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args){
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for(int i = 0; i< 1000; i++){
            System.out.println("main" + i);
            if(i == 900){
                testStop.stop();
                System.out.println("线程停止了");
            }
        }
    }
}
