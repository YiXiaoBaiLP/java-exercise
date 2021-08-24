package com.yixiaobai.lp.chap5.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 输入类名，输出类的全部信息
 * @author yixiaobai
 *
 */
public class ReflectionTest {
	public static void main(String[] args) {
		
		// read class name from command line args or user input
		String name;
		if(args.length > 0 ) {
			name = args[0];
		}else {
			// 获取控制台用户输入
			Scanner in = new Scanner(System.in);
			System.out.println("Enter Class name(e.g. java.util.Date): ");
			name = in.next();
		}
		
		try {
			// print class name and superclass name (if != Object)
			Class clazz = Class.forName(name);
			// 获取到父类的信息
			Class superClazz = clazz.getSuperclass();
			// clazz.getModifiers() 方法返回一个int类型的数值
			// Modifier.toString()将int数字使用 & 操作符进行判断具体的操作符
			String modifiers = Modifier.toString(clazz.getModifiers());
			if(modifiers.length() > 0 ) {
				System.out.println(modifiers + " ");
			}
			// 输入类的全路径
			System.out.print("class " + name);
			// 获取继承的父类（除Object类）
			if(superClazz != null && superClazz != Object.class) {
				// 输出当前类继承自哪个类的全路径
				System.out.print(" extends " + superClazz.getName());
			}
			System.out.print("\n{\n");
			printConstructors(clazz);
			System.out.println();
			printMethods(clazz);
			System.out.println();
			printFields(clazz);
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			System.exit(0);
		}
	}

	/**
	 * 这个类输出所有的构造器
	 * Prints all constructors of a class
	 * @param cl
	 */
	public static void printConstructors(Class cl) {
		// 获取到类的构造器数组
		Constructor[] constrctors = cl.getDeclaredConstructors();
		// 循环遍历构造器数组
		for(Constructor c :constrctors) {
			// 获取构造器的全路径
			String name = c.getName();
			System.out.print(" ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0) {
				System.out.print(modifiers + "  ");
			}
			System.out.print(name + "(");
			
			// 获取构造器的参数列表
			Class[] parameteTypes = c.getParameterTypes();
			for(int j = 0; j < parameteTypes.length; j++) {
				if(j > 0) {
					System.out.print(", ");
				}
				System.out.print(parameteTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * Prints all methods of a class
	 * @param cl
	 */
	public static void printMethods(Class cl) {
		// 获取所有的方法
		Method[] methods = cl.getDeclaredMethods();
		for(Method m : methods) {
			// 获取类的返回类型
			Class retType = m.getReturnType();
			// 获取类的全路径
			String name = m.getName();
			
			System.out.print("  ");
			// print modifiers, return type and method name
			// 获取方法的作用域
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print(retType.getName() + " " + name + "(");
			// print parameter types
			Class[] paramTypes = m.getParameterTypes();
			for(int j = 0; j < paramTypes.length; j++) {
				if(j > 0) {
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * Prints all field of a class
	 * @param cl
	 */
	public static void printFields(Class cl) {
		Field[] fields = cl.getDeclaredFields();
		
		for(Field field: fields) {
			Class type = field.getType();
			String name = field.getName();
			System.out.print("  ");
			String modifiers = Modifier.toString(field.getModifiers());
			if(modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.println(type.getName() + " " + name + ";");
		}
	}
}
