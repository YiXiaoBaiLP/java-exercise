package com.yixiaobai.lp.chap6.interfaces;

import java.util.Arrays;

/**
 * This program demonstrates the use of the Comparable interface.
 * @version 1.0.0
 * @author yixiaobai
 *
 */
public class EmployeeSortTest {

	public static void main(String[] args) {

		Employee[] staff = new Employee[3];
		staff[0]= new Employee("Harry Hacker", 35000);
		staff[1]= new Employee("Carl Cracker", 75000);
		staff[2]= new Employee("Tony Tester", 38000);
		
		Arrays.sort(staff);
		
		for(Employee e : staff) {
			System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
		}
	}
	
}
