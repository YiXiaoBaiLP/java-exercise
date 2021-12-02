package	buzz.yixiaobai.test.ParamTest;

public class ParamTest {
	public static void main(String[] args) {
		
		/*
		 *  Test 1: Methods can't modify numeric parameters
		 *  	1: 一个方法不能修改一个基本数据类型的参数。
		 */
		System.out.println("Testing tripleValue");
		double percent = 10;
		System.out.println("Before: percent = " + percent);
		tripleValue(percent);
		System.out.println("After: percent = " + percent);
		
		/*
		 *	Test 2: Methods can change the state of object parameters 
		 * 		2: 一个方法可以改变一个对象参数的状态
		 */
		System.out.println("\nTesting tripleSalary:");
		Employee harry = new Employee("Harry", 50000);
		System.out.println("Before: salary = " + harry.getSalary());
		tripleSalary(harry);
		System.out.println("After: salary = " + harry.getSalary());
		
		/*
		 *  Test 3: Methods can't attach new object to object parameters
		 * 	Test 3: 一个方法不能让对象参数引用一个新的对象
		 */
		System.out.println("\nTesting swap:");
		Employee a = new Employee("Alice", 7000);
		Employee b = new Employee("Bob", 6000);
		System.out.println("Before: a = " + a.getName());
		System.out.println("Before: b = " + b.getName());
		swap(a, b);
		System.out.println("After: a = " + a.getName());
		System.out.println("Aftre: b = " + b.getName());
	}
	
	public static void tripleValue(double x) {
		x = 3 * x;
		System.out.println("End of method " + x);
	}
	
	public static void tripleSalary(Employee x) {
		
		x.raiseSalary(200);
		System.out.println("End of method salary = " + x.getSalary());
	}
	
	public static void swap(Employee x, Employee y) {
		
		Employee temp = x;
		x = y;
		y = temp;
		System.out.println("End of method : x = " + x.getName());
		System.out.println("End of method : y = " + y.getName());
		
	}
}

class Employee {
	
	private String name;
	private double salary;
	
	public Employee(String n, double s) {
		
		name = n;
		salary = s;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
