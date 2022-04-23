package buzz.yixiaobai.thread.demo04;

/**
 * 被代理者
 * @author yixiaobai
 * @create 2022/04/23 下午2:53
 */
public class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("秦老师要结婚了，超开心！！！");
    }
}
