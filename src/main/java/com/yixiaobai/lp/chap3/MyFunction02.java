package com.yixiaobai.lp.chap3;

/**
 * 函数式接口
 * 
 * @author yixiaobai
 *
 */
@FunctionalInterface
public interface MyFunction02<T, R> {

	R getValue(T t1, T t2);
}
