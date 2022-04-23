package buzz.yixiaobai.thread.demo02;

/**
 * 模拟龟兔赛跑
 * @author yixiaobai
 * @create 2022/04/23 下午12:58
 */
public class Race implements  Runnable{

    // 胜利者
    private static String winner;

    @Override
    public void run() {
        for(int i = 0; i <= 100; i++){
            // 兔子每次睡眠2毫秒
            if(Thread.currentThread().getName().equals("兔子") && (i % 10 ==0)){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 判断比赛是否结束
            if(gameOver(i)){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i +"步。");

        }
    }

    /**
     * 判断比赛是否完成
     * @param count
     * @return
     */
    private static boolean gameOver(int count){
        // 判读是否有胜利者，如有直接返回
        if(winner != null){
            return true;
        }
        if(count >= 100){
            winner = Thread.currentThread().getName();
            System.out.println(winner + "获胜了！");
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // 创建一个赛道
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
