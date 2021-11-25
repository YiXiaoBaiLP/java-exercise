package buzz.yixiaobai.ConstructorTest;

import java.util.Random;

/**
 * 	本类的特性
 * 		1、重载构造器
 * 		2、用this(...)调用另一个构造器
 * 		3、无参数构造器
 * 		4、对象初始化模块
 * 		5、静态初始化模块
 * 		6、实例域初始化块
 * 
 * @author yixiaobai
 *
 */
public class ConstructorTest {
	public static void main(String[] args) {
		// fill the staff array with three Employee objects
		Employee[] staff =new Employee[3];
		
		staff[0] = new Employee("Harry", 40000);
		staff[1] = new Employee(600000);
		staff[2] = new Employee();
		
		// print out information about all Employee object
		for(Employee e : staff) {
			System.out.println("name = " + e.getName() + ", id = " + e.getId() + ", salary = " + e.getSalary());
		}
	}
}

class Employee {
	private static int nextId;
	
	private int id;
	private String name = ""; // instance field initalization
	private double salary;
	
	/*
	 * static initialization block
	 * 		静态初始化域
	 */
	static {
		Random generator = new Random();
		// set nextId to a random number between 0 and 9999
		// 给 nextId设置随机数 0～9999
		nextId = generator.nextInt();
	}
	
	/*
	 * 	object initialization block
	 * 	初始化域
	 * 
	 */
	{
		id = nextId;
		nextId++;
	}

	/*
	 * 	three overloaded constructors
	 */
	public Employee(String n, double s) {
		name = n;
		salary = s;
	}
	
	public Employee(double s) {
		// calls the Employee(String, double) constructor
		this("Employee #" + nextId, s);
	}
	
	/*
	 * 	the default constructor
	 */
	public Employee() {
		/*
		 * name initialized to "" -- see above
		 * salary not explicitly set -- initialized to 0
		 * id initialized in initialization block
		 * 
		 */
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public int getId() {
		return id;
	}
}