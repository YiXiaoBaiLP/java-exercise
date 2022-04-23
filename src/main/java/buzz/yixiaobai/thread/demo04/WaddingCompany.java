package buzz.yixiaobai.thread.demo04;

/**
 * 代理者
 * @author yixiaobai
 * @create 2022/04/23 下午2:54
 */
public class WaddingCompany implements Marry{

    private Marry marry;

    public WaddingCompany(Marry marry){
        this.marry = marry;
    }

    @Override
    public void HappyMarry() {
        before();
        marry.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚前要先买房、买车！！！");
    }

    private void after() {
        System.out.println("结婚后要生孩子，养孩子！！！");
    }
}
