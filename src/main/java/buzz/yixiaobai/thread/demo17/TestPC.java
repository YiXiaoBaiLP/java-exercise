package buzz.yixiaobai.thread.demo17;

/**
 * 测试：生产者消费型-->利用缓冲区解决：管程法
 * @author yixiaobai
 * @create 2022/04/25 下午8:58
 */
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Consumer(container).start();
    }
}

/**
 * 生产者
 */
class Productor extends Thread {
    SynContainer container;
    public Productor(SynContainer container){
        this.container = container;
    }

    /**
     * 生产
     */
    @Override
    public void run(){
        for(int i = 1; i <= 100; i++){
            System.out.println("生产了第" + i + "只鸡");
            container.push(new Chicken(i));
        }
    }
}

/**
 * 消费着
 */
class Consumer extends Thread {

    SynContainer container;

    public Consumer(SynContainer container){
        this.container = container;
    }

    /**
     * 消费
     */
    @Override
    public void run(){
        for(int i = 1; i <= 100; i++){
            System.out.println("消费了--->第" + container.pop().id + "只鸡");
        }
    }
}

/**
 * 产品
 */
class Chicken {

    // 产品编号
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {

    // 需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;

    /**
     * 生产者放入产品
     * @param chicken
     */
    public synchronized void push(Chicken chicken){
        // 如果容器满了，就需要等待消费者消费
        if(count == chickens.length) {
            // 通知消费者生产，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果没有满，我们就需要丢入产品
        chickens[count] = chicken;
        count++;

        // 可以通知消费者消费了
        this.notify();
    }

    /**
     * 消费者消费产品
     */
    public synchronized Chicken pop() {
        // 判断能否消费
        if(count == 0){
            // 等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果可以消费
        count--;
        Chicken chicken = chickens[count];

        // 吃完了，通知生产者生产
        this.notify();

        return chicken;
    }
}