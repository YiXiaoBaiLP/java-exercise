package com.yixiaobai.lp.chap6.lambda;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Lambda 练习01
 */
public class LambdaTest01 {

    @Test
    public void lambdaTest01(){
        repeat(10, () -> System.out.println("Hello Lambda!"));
    }

    public static void repeat(int n, Runnable action){
        for(int i = 0; i < n; i++){
            action.run();
        }
    }
    /**
     * 在lambda表达式中引用变量，而这个变量肯能在外部变化，则这个是不合法的
     * 最终变量：这个变量初始化之后就不会在为它赋新值。
     * 例如：
     * @param text
     * @param count
     */
    public static void repeat(String text, int count){
        for(int i = 1; i <= count; i++){
            ActionListener listener = event -> {
//                System.out.println(i + ": " + text);
                // 此处错误，Lambda中只能使用final的全局变脸
            };
            new Timer(1000, listener).start();
        }
    }

    /**
     * lambda表达式中声明与一个局部变量同名的参数或局部变量是不合法的。
     */
    public static void first(){

        Path first = Paths.get("/usr/bin");
        // 局部变量名不能与参数名称相同
//        Comparator<String> comp = (first, second) ->
//            first.length() - second.length();
    }

    /**
     * 在lambda表达式中使用this关键字时，是指创建这个Lambda表达式的方法的this参数。
     */
    public void init(){
        ActionListener listener = event -> {
            // 表达式this.toString()方法调用的是类的toString()方法，而不是Actionlistener实例的方法。
            System.out.println(this.toString());
        };
    }
}
