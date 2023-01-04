package buzz.yixiaobai.lambda.chap6.chap6_2_1;

import org.junit.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

public class Summarizing {

    @Test
    public void test01() {
        // 使用比较器找到热量最高的菜肴
        findMostCaloricDishUsingComparator();
        // 获取最大值、最小值、数量、平均值
        getSummarizing();
    }

    public static void findMostCaloricDishUsingComparator(){
        // 获取一个卡路里比较器
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = Dish.menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Dish.menu.stream().collect(Collectors.summarizingLong(Dish::getCalories));
        Dish.menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));

    }

    /**
     * 获取最大值、最小值、数量、平均值
     */
    public static void getSummarizing(){
        IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        long count = menuStatistics.getCount();
        System.out.println(menuStatistics);
    }
}
