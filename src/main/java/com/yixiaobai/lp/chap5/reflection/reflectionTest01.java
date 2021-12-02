package com.yixiaobai.lp.chap5.reflection;

import org.junit.Test;

import java.util.Random;

/**
 * 获取class的几种方式
 * @author yixiaobai
 *
 */
public class reflectionTest01 {
	
	/**
	 * 第一种通过getClass()方法反射获取class的方式
	 */
	@Test
	public void test01() {
		Employee e = new Employee();
		Class emp = e.getClass();
		System.out.println("通过getClass()方法获取类的全路径：" + emp);
		// 也可以使用getName()方法来获取类的实例
		System.out.println("通过getNamea()方法来获取类的全路径：" + emp.getName());
	}
	
	/**
	 * 第二种：通过静态类forClass()
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void test02() throws ClassNotFoundException {
		Class clazz = Class.forName("com.yixiaobai.lp.chap5.reflection.Employee");
		System.out.println("通过Class.forName()获取的类路径：" + clazz);
		
	}

	/**
	 * 第三种：通过 方法.class方式获取类的实例
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@Test
	public void test03() throws InstantiationException, IllegalAccessException {
		
		Class clazz = Employee.class;
		System.out.println("通过类.class 方式获取类的实例：" + clazz);
		// 获取类的实例
		clazz.newInstance();
		
	}
	
	/**
	 * 通过反射获取类的实例
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void test04() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		String s = "java.util.Random";
		Class clazz = Class.forName(s);
		Random rand = (Random)clazz.newInstance();
		int x = rand.nextInt(10);
		System.out.println(x);
	}
}
