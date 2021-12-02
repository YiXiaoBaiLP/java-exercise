package buzz.yixiaobai.stream.filter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 初次使用Stream流
 * @author yixiaobai
 *
 */
public class FilterStreamDemo {

	// 内部迭代：迭代由Stream API完成
	@Test
	public void filterTest1() {
	
		List<String> strList = new ArrayList<>();
		/*
		 * 筛选与切片
		 * 	filter：接受Lambda，从流中排除某些元素
		 *  limit：截断流，使其元素不超过给定的数量
		 *  skip(n)：跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
		 *  distinct：筛选，通过所产生元素的hashCode()和equals()去筛选重复元素
		 */
		// 中间操作：不会执行任何操作
		Stream<String> stream = strList.stream()
				.limit(10)
				.skip(2)
				.distinct()
				.filter((e) -> {
					System.out.println("短路");
					return false;
				})
				.filter((e) -> {
					System.out.println("Stream API的中间操作");
					return true;
				});
		// 终止操作：一次性执行全部内容，即“惰性求值”
		stream.forEach(System.out::println);
	}
	
}
