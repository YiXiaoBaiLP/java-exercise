package com.yixiaobai.lp.chap6.timer;

import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 
 * 回调：是一种常见的程序设计模式。在这种模式中，可以指出某个特定事件发生时应该采取的动作。
 * 每十秒打印一次信息，并响铃一次。
 * @author yixiaobai
 * @version 1.0.0
 */
public class TimerTest {

	public static void main(String[] args) {
		java.awt.event.ActionListener  listener = new TimerPrinter();
		// construct a timer that calls the listener
		// once every 10 seconds
		// new Timer(int interval, ActionListener listener)：构造一个定时器，每隔interval毫秒通告listener一次。
		Timer t = new Timer(10000, listener);
		// 启动定时器
		t.start();
		// showMessgeDialog(Component parent, Object message)
		// 显示一个包含一条消息和OK按钮的对话框。这个对话框将位于其parent组件的中央。如果parent为null，对话框将显示在屏幕中央。
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TimerPrinter implements java.awt.event.ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// 每隔十秒显示一次
		System.out.println("An the tone, the time is " + new Date());
		// getDefaultToolkit()：获得默认的工具箱。工具箱包含有关GUI环境的信息。
		// beep():响铃一次
		java.awt.Toolkit.getDefaultToolkit().beep();
	}
	
}
