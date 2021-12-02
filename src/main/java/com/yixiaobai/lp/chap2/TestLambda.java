package com.yixiaobai.lp.chap2;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


/*
 * 一、Lambda表达式的基础语法：Java8中引入了一个新的操作符“->” 该操作符称为箭头操作符或Lambda操作符
 * 			箭头操作符将Lambda表达式拆分成两部分：
 * 
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式中所需执行的功能，即Lambda体（需要实现的功能）
 * 
 * 语法格式一：
 * 			无参数，无返回值
 * 			() -> System.out.println("Hello Lambda!");
 * 
 * 语法格式二：
 * 			有一个参数，并且无返回值的方法
 * 
 * 语法格式三：
 * 			只有一个参数，小括号可以不写
 * 			x -> System.out.println(x);
 * 
 * 语法格式四：
 * 			有两个或两个以上的参数，并且Lambda中有多条语句，并且有返回值
 * 
 * 语法格式五：
 * 			如果Lambda表达式中，只有一条语句则大括号与return可以不些
 * 			Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 * 
 * 语法格式六：
 * 			Lambda表达式的参数列表的数据类型可以不写数据类型，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * 			Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
 * 
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * 
 * 二：Lambda表达式需要“函数式接口”的支持
 * 函数式接口：当接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解@FunctionalInterface修饰一下
 * 			可以检查是否是函数式接口
 * 
 */
public class TestLambda {

	@Test
	public void test1() {
		// java8之前，局部变量必须是final修饰的
		// java8之后，可以不用final修饰，但是在局部内部类中不能修改此变量的值。
		int num = 1;
		
		// java8之前使用匿名类的方式
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World!");
			}
		};
		r.run();
		num++;
		System.out.println("----------------------------------------------" + num);
		// Java8使用匿名类的方式
		Runnable run = () -> System.out.println("Hello Lambda!");
		run.run();
	}
	
	/**
	 * Lambda有一个参数，并没有返回值
	 */
	@Test
	public void test2() {
		// 有一个参数的Lambda方法
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("我大Java-Lambda");
	}
	
	/**
	 *  Lambda 当有一个参数时，小括号可以不用写
	 */
	@Test
	public void test2_1(){
		Consumer<String> con = x -> System.out.println(x);
		con.accept("我大Java-Lambda01");
	}
	
	@Test
	public void Test3() {
		Comparator<Integer> com = (x, y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
		
		com.compare(10, 50);
	}
	
	@Test
	public void Test4() {
		// 只有一条语句时，可以省略{}与return
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
	}
	
	@Test
	public void Test5() {
	
		List<String> list = new ArrayList<>();
		// 通过目标可以推断出此参数类型
		show(new HashMap<>());
	}
	
	public void show(Map<String, String> map) {
		
	}
	
	// 需求：对一个数进行运算
	@Test
	public void test6() {
		Integer num = operation(100, (x) -> x * x );
		System.out.println(num);
		
		System.out.println(operation(200, (x) -> x + 200));
	}
	
	public Integer operation(Integer num, MyFunction mf) {
		return mf.getValue(num);
	}
	
}
