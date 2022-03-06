package com.yixiaobai.lp.chap6.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 内部类测试
 */
public class InnerClassTest {

    public static void main(String[] args){
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals
 */
class TalkingClock{

    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     * @param interval
     * @param beep
     */
    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock
     */
    public void start(){
        ActionListener listener = new TimerPrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    /**
     * 创建一个内部类
     */
    public class TimerPrinter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("At the tone, the time is " + new Date());
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
