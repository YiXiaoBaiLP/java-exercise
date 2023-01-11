package buzz.yixiaobai.lambda.chap6.chap6_3;

import buzz.yixiaobai.lambda.chap6.chap6_2_1.Dish;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 使用groupBy函数
 */
public class FirstGroupBy {

    @Test
    public void firstGroupByTest() {
        // 通过类型来实现分组功能
        Map<Dish.Type, List<Dish>> typeListMap = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(typeListMap);
    }
}
