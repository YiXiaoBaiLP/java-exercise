package com.yixiaobai.lp.chap1;

/**
 * 声明一个函数式接口
 * @author liupeng
 *
 * @param <T>
 */
@FunctionalInterface
public interface Predicate<T> {
	
	boolean test(T t);

}
