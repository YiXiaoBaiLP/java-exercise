package yixiaobai.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PrettyPrintApple {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(15, "Red"),
										  new Apple(120, "Blue"),
										  new Apple(50, "Greed"));
		
		
		// 将接口的实现传递给方法
		prettyPrintApple(inventory, new AppleSimpleFormatter());
		prettyPrintApple(inventory, new AppleFancyFormatter());
		
		// 使用java匿名类
		// 匿名类的缺点：
		//	1.看起来很笨重
		//	2.会占用很多的空间
		prettyPrintApple(inventory, new AppleSimpleFormatter() {
			// 创建了一个匿名方法，此方法使用完成后就会销毁。
			public boolean test(Apple apple) {
				return "Red".equals(apple.getColor());
			}
		});
		
		// 使用Java8 的Lambda方式
		
	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter a) {
		
		for(Apple apple : inventory) {
			String output = a.accept(apple);
			System.out.println(output);
		}
	}
	
	
	/**
	 * 	此方法可以传入任意类型的List集合 	
	 * @param <T>
	 * @param list
	 * @param p
	 * @return
	 */
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for(T e : list) {
			if(p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
	
}

/**
 *  创建一个接口
 * @author yixiaobai
 *
 */
interface AppleFormatter {
	String accept(Apple apple);
}

/**
 *  实现接口，来表示各种行为
 * @author yixiaobai
 *
 */
class AppleFancyFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		int character = apple.getWeight();
		return "A " + character + " " + apple.getColor() + " apple!";
	}
}

/**
 * 	实现接口，来表示各种行为
 * @author yixiaobai
 *
 */
class AppleSimpleFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		return "An apple of" + apple.getWeight() + "g!";
	}
}


/**
 * 	一个Aplle的实体类
 * 
 * @author yixiaobai
 *
 */
class Apple {
	
	private int weight = 0;
	private String color = "";
	
	public Apple(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", color=" + color + "]";
	}
	
}
