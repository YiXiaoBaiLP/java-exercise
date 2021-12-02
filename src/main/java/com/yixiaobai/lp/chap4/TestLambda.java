package com.yixiaobai.lp.chap4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * Java8 内置的四大核心函数式接口
 * 
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 * 
 * Supplier<T> : 供给型接口
 * 		T get();
 * 
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 * 
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 * 
 */
public class TestLambda {

	// Consumer<T> 消费型接口
	@Test
	public void test1() {
		happy(100000, (m) -> System.out.println("你们刚哥喜欢大宝剑，每次消费" + m +"元"));
	}
	
	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}

	@Test
	public void test2() {
		List<Integer> numberList = getNumberList(10, () -> (int)(Math.random() * 100));
		for(Integer num : numberList) {
			System.out.println(num);
		}
	}
	// 供给型接口
	public List<Integer> getNumberList(int num, Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		return list;
	}
	
	@Test
	public void test3() {
		String strTrim = getStr("\n\n\n\n\n\n\n sljdkflaskjdfl", (str) -> str.trim());
		System.out.println(strTrim);
	}
	// 函数式接口
	public String getStr(String str, Function<String, String> fun) {
		return fun.apply(str);
	}
	
	@Test
	public void test4() {
		List<String> listStr = Arrays.asList("helolo", "word", "pass", "Techer", "student");
		List<String> str = filterStr(listStr, (s) -> s.length() > 2);
		for(String s : str) {
			System.out.println(s);
		}
	}
	// 断言型接口
	// 需求：将满足条件的字符串，放入集合中
	public List<String> filterStr(List<String> listStr, Predicate<String> pre){
		List<String> list = new ArrayList<String>();
		for(String str : listStr) {
			if(pre.test(str)) {
				list.add(str);
			}
		}
		return list;
	}
}
