package com.yixiaobai.lp.chap6.interfaces;

public class Employee implements Comparable<Employee>{

	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	public void raisSalary(double byPercent) {
		double raise = salary * byPercent/100;
		salary += raise;
	}

	/**
	 * Compares employee by salary
	 * @param other another Employee object
	 * @return a negative vlaue if this employee has a lower salary than
	 * otherObject, 0 if the salaries are the same, a positive value otherwise
	 */
	@Override
	public int compareTo(Employee other) {
		return Double.compare(salary, other.salary);
	}

}
