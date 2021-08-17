package com.yixiaobai.lp.chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 *  Java8 内置的四大函数型接口
 *  
 * @author yixiaobai
 *
 */
public class TestLambda2 {

	/**
	 * 消费型接口
	 */
	@Test
	public void test01() {
		happy(100, (m) -> System.out.println("你喜欢大宝剑，每次消费" + m + "元"));
		Consumer<String> con = System.out::println;
		con.accept("我是System.out.println(\"\") 方法输出的内容！！！");
	}
	
	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}
	
	/**
	 * 供给型接口
	 */
	@Test
	public void test02() {
		List<Integer> randomList = getNumList(10, () -> (int)(Math.random() * 100));
		randomList.forEach((x)-> System.out.println(x));
	}
	
	// 需求：产生一些指定整数，并放入到集合中
	public List<Integer> getNumList(int num, Supplier<Integer> sup){
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		return list;
	}
	
	/**
	 * 函数型接口
	 */
	@Test
	public void test03() {
		String trimStr = strHandler("\r\t\r\t aldkfjals", (str) -> str.trim());
		System.out.println(trimStr);
	}
	
	// 需求：用于处理字符串
	public String strHandler(String str, Function<String, String> fun) {
		return fun.apply(str);
	}
	
	/**
	 * 断言型接口
	 */
	@Test
	public void test04() {
		String java = "Java";
		boolean b = getValue(java, (str) -> str.equals("Hell Java"));
		System.out.println(b);
	}
	
	public boolean getValue(String str, Predicate<String> pred) {
		return pred.test(str);
	}
	
	@Test
	public void test05() {
		List<String> asLists = Arrays.asList("Liupeng", "Yes", "Ok", "JiaYou", "Listnuli");
		List<String> list = filterList(asLists, (str) -> str.length() > 6);
		list.forEach((str) -> System.out.println(str));
	}
	
	public List<String> filterList(List<String> strList, Predicate<String> pre){
		List<String> list = new ArrayList<>();
		for(String str : strList) {
			if(pre.test(str)) {
				list.add(str);
			}
		}
		return list;
	}
	
}
