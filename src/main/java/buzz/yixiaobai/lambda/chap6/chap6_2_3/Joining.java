package buzz.yixiaobai.lambda.chap6.chap6_2_3;

import buzz.yixiaobai.lambda.chap6.chap6_2_1.Dish;
import org.junit.Test;

import java.util.stream.Collectors;

/**
 * 使用joining()方法来链接字符串
 */
public class Joining {

    @Test
    public void test(){
        joiningDemo01();
        joiningDemo02();
    }

    /**
     * 拼接菜肴名称
     */
    public static void joiningDemo01(){
        String joining = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println("拼接后的菜肴名称：" + joining);
    }

    /**
     * 拼接菜肴名称，并添加指定的分隔符
     */
    public static void joiningDemo02(){
       String joining =  Dish.menu.stream()
               .map(Dish::getName)
               .collect(Collectors.joining(", "));
       System.out.println("拼接后的菜肴名称：" + joining);
    }
}
