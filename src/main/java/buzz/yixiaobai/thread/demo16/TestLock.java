package buzz.yixiaobai.thread.demo16;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁
 * @author yixiaobai
 * @create 2022/04/25 下午6:09
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock02 testLock = new TestLock02();
        new Thread(testLock, "线程一").start();
        new Thread(testLock, "线程二").start();
        new Thread(testLock, "线程三").start();
        new Thread(testLock, "线程四").start();
    }
}

class TestLock02 implements Runnable {

    @Override
    public void run(){

        try {
            getTicket();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private int ticketNums = 10;
    private final ReentrantLock lock = new ReentrantLock();

    public void getTicket() throws InterruptedException {
        while (true){
            try{
                lock.lock();

                if(ticketNums <= 0){
                    break;
                }
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "抢到了第" + ticketNums-- + "票");
            } catch(Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}