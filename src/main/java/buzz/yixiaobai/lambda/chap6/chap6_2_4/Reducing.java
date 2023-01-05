package buzz.yixiaobai.lambda.chap6.chap6_2_4;

import buzz.yixiaobai.lambda.chap6.chap6_2_1.Dish;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用reducing（归约）
 */
public class Reducing {

    @Test
    public void test(){
        calculateTotalCalories();
        acquireMaxCalorie();
        collectOrReduce();
    }

    /**
     * 计算总热量
     */
    public static void calculateTotalCalories(){
        // 计算菜单的总热量
        // Collectors.reduciing()
        // 第一个参数：归约的启始值，当元素中没有值时返回此值
        // 第二个参数：将对象转换成某个值
        // 第三个参数：将两个项目累积成一个同类型的值
        Integer total = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("菜单的总热量为：" + total);
    }

    /**
     * 获取最高热量的菜
     */
    public static void acquireMaxCalorie() {
        Optional<Dish> maxCalorie = Dish.menu.stream()
                .collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println("获取到最高热量的菜：" + maxCalorie.get().getCalories());
    }

    /**
     * 不推荐此方式reduce()方式，推荐Collectors.reducing()方法
     * 多线程下reduce()方式会出现数据问题
     */
    public static void collectOrReduce() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        // 将数据整合成一个集合，通过reduce()方法
        List<Integer> reduce = stream.reduce(new ArrayList<>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l;
                }, (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1;
                });
    }
}
