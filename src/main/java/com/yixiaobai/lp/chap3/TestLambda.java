package com.yixiaobai.lp.chap3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/*
 * 1. 调用Collections.sort()方法，通过定制排序比较两个Employee（先用年龄比， 年龄相同按姓名比） 使用Lambda作为参数传递
 * 
 * 2. 
 * 
 * 
 */
public class TestLambda {

	List<Employee> emps = Arrays.asList(
					new Employee(101, "田七", 18, 9999.99),
					new Employee(102, "张三", 59, 6666.66),
					new Employee(103, "李四", 28, 3333.33),
					new Employee(104, "王五", 8, 7777.77),
					new Employee(105, "赵六", 38, 5555.55));
	@Test
	public void test1() {
		Collections.sort(emps, (o1, o2) -> {
				if(o1.getAge() == o2.getAge()) {
					return o1.getName().compareTo(o2.getName());
				}else {
					return Integer.compare(o1.getAge(), o2.getAge());
				}
		});
		for(Employee emp : emps) {
			System.out.println(emp);
		}

	}
	
	@Test
	public void test02() {
		// 给字符串去掉首尾空格
		String str02 = strHandler("\t\t\t\t\t Lambda牛逼", (str) -> str.trim());
		System.out.println(str02);
		
		// 将字符串转换成大写
		String upper = strHandler("abcde", (str) -> str.toUpperCase());
		System.out.println(upper);
		
		// 截取字符串
		String sub = strHandler("Java威武123123123", (str) -> str.substring(2, 7));
		System.out.println(sub);
	}
	
	// 需求：用于处理字符串的方法
	public String strHandler(String str, MyFunction mf) {
		return mf.getValue(str);
	}
	
	@Test
	public void Test03() {
		op(100L, 200L, (x, y) -> x + y);
		
		op(100L, 300L, (x, y) -> x * y);
	}

	// 需求：对于两个Lang类型数据进行处理
	public void op(Long l1, Long l2, MyFunction02<Long, Long> mf) {
		System.out.println(mf.getValue(l1, l2));
	}
}
