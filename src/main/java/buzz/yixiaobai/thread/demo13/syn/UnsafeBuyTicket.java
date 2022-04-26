package buzz.yixiaobai.thread.demo13.syn;

/**
 * 同步方法
 * @author yixiaobai
 * @create 2022/04/24 下午7:17
 */
public class UnsafeBuyTicket {

    // 票数
    private Integer ticketNums = 10;
    // 线程停止控制flag
    private boolean flag = true;

    /**
     * 同步方法，解决票数安全问题
     * @param ticket
     */
    public synchronized void buyTicket(UnsafeBuyTicket ticket) {

        // 当没有票时，直接返回
        if(ticket.ticketNums <= 0 ){
            ticket.flag = false;
            return;
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "买到了第" + ticket.ticketNums-- + "票");
    }

    public static void main(String[] args){
        UnsafeBuyTicket ticket = new UnsafeBuyTicket();
        while(ticket.flag){
            new Thread(()->ticket.buyTicket(ticket), "普通人").start();
            new Thread(()-> ticket.buyTicket(ticket), "苦逼的上班族").start();
            new Thread(() -> ticket.buyTicket(ticket), "万恶的黄牛党").start();
        }
    }
}
