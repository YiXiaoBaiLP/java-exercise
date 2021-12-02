package com.yixiaobai.lp.chap5;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/*
 * 一、方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
 * 		（可以理解为方法引用是Lambda表达式的另一种表现形式）
 * 
 * 主要有三种语法格式：
 * 	 对象:: 对象方法名
 * 
 * 	 类 :: 静态方法名
 * 
 *   类 :: 实例方法名
 *   
 *   注意：
 *   	1、Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致。
 *    	2、若Lambda参数列表中的第一参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用 ClassName :: method
 */
public class TestMethodRef {

	@Test
	public void test1() {
		Consumer<String> str = (s) -> System.out.println(s);
		str.accept("asdjflasdjf");
		Consumer<String> str2 = System.out::println;
		
	}
	
	@Test
	public void test2() {
		BiPredicate<String, String> bp = String::equals;
		Comparator<Integer> com = Integer::compareTo;
	}
	
	@Test
	public void test3() {
		BiFunction<String, String, Boolean> sss = String::equals;
		boolean b = sss.equals("sss");
		System.out.println(b);
	}
}
