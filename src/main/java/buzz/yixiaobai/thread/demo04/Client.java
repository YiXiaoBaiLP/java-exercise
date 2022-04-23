package buzz.yixiaobai.thread.demo04;

/**
 * 静态代理模式-客户端
 * @author yixiaobai
 * @create 2022/04/23 下午2:57
 */
public class Client {
    public static void main(String[] args) {
        // 创建代理者
        WaddingCompany proxy = new WaddingCompany(new You());
        proxy.HappyMarry();
    }
}
