package buzz.yixiaobai.stream.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;



/**
 * stream映射Demo
 * @author yixiaobai
 *
 */
public class MapStreamDemo {

	@Test
	public void test() {
		/*
		 * 映射：
		 * 	map：接受Lambda，将元素转换成其他形式或提取信息。接受一个函数作为参数，该函数会被引用到
		 * 每个元素上，并将其映射成一个新元素。
		 *  flatMap：接收一个函数作为参数，将流中的每个值都转换成利另一个流，然后把
		 * 所有流连接成一个流。
		 */
		List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
		// 获取stream流
		list.stream()
			.map((str) -> str.toUpperCase())
			.forEach(System.out::println);
		System.out.println("-----------------------------------");
		Stream<Stream<Character>> stream = list.stream()
				.map(MapStreamDemo :: filterCharacter);
		stream.forEach((sm) -> {
			sm.forEach(System.out::println);
		});
		System.out.println("-----------------------------------");
		
		Stream<Character> sm = list.stream()
		.flatMap(MapStreamDemo :: filterCharacter);
	}
	
	/**
	 * 类似与 Stream API 中的 flatMap()方法
	 * @param str
	 * @return
	 */
	public static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		for(Character ch : str.toCharArray()) {
			list.add(ch);
		}
		return list.stream();
	}
}
