package buzz.yixiaobai.lambda.chap1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/***
 *  初次使用Lambda表达式
 * @author yixiaobai
 *
 */
public class LambdaTest {
	
	public static void main(String[] args) {
		
		// 创建一个String的List数组
		// 这里创建了三个String的ArrayList的集合
		List<String> stringList = Arrays.asList(
				new String("ONE"),
				new String("TWO"),
				"3");
		
		System.out.println("String List 的长度：" + stringList.size());
		
		for(String str : stringList) {
			System.out.println(str);
		}
		
		// java 中的八进制数字
		int i1 = 010;
		int i2 = 011;
		// 输出8
		System.out.println(i1);
		// 输出9
		System.out.println(i2);
		
		// 判断变量是否是一个数值
		// 验证一个值是否为数值
		if(Double.isNaN(3.14D)) {
			System.out.println("不是一个数值");
		}else {
			System.out.println("是一个数值");
		}
		// 输出结果是：0.8999999999999999
		// 浮点类型无法正确的表示1/10的数值，应当使用BigDecimal类。
		System.out.println(2.0-1.1);
		// 这里拼接后的字符串为：stsrsJsosisn
		// 第一个参数为拼接的字符串，第二个往后的参数为需要拼接的字符串
		String strJoin = String.join("String:", "t", "r", "J", "o", "i", "n");
		System.out.println("strJoin 的值为：" + strJoin);
		
		// 获取当前的日期
		LocalDate localDate = LocalDate.now();
		System.out.println("本地当前日期为：" + localDate);
		// 使用Lambda表达式，获取stringList集合中的 ONE 元素
		List<String> oneList = filter(stringList, (String str) -> "ONE".equals(str));
		System.out.println("oneList中的ONE元素：" + oneList.toString());
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("Integer List的长度为：" + intList.size());
		// 使用Lambda表达式，获取Integer中大于5的元素。
		List<Integer> integerList = filter(intList, (Integer i) -> i > 5);
		System.out.println(integerList.toString());
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> result = new ArrayList<>();
		for(T e : list) {
			if(p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
}