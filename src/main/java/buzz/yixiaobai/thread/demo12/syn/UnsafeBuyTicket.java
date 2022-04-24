package buzz.yixiaobai.thread.demo12.syn;

/**
 * 线程不安全-买票
 * @author yixiaobai
 * @create 2022/04/24 下午4:43
 */
public class UnsafeBuyTicket {

    // 票数
    private static int ticketNums = 10;
    // 线程停止控制flag
    private static boolean flag = true;

    public static void buyTicket() {
        // 当没有票时，直接返回
        if(ticketNums <= 0 ){
            flag = false;
            return;
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "票");

    }

    public static void main(String[] args){

        while(flag){
            new Thread(()->buyTicket(), "普通人").start();
            new Thread(()-> buyTicket(), "苦逼的上班族").start();
            new Thread(() -> buyTicket(), "万恶的黄牛党").start();
        }
    }
}
