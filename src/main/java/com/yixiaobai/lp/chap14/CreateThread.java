package com.yixiaobai.lp.chap14;

/**
 * 构建一个新的线程Demo01
 * @author yixiaobai
 * @create 2022/03/17 下午6:06
 */
public class CreateThread {

    public static void main(String[] args) {
        // 创建一个线程
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("我创建了一个新的线程。");
            }
        });
        // 启动这个线程，将引发调用run()方法
        Thread.State threadState = thread.getState();
        System.out.println(threadState);
        // 向线程发送中断请求
        thread.interrupt();
        // 查看当前的线程会否被中断
        boolean isInterrup = thread.isInterrupted();
        System.out.println("当前线程是否被中断：" + isInterrup);
        thread.start();
        Thread.State threadState2 = thread.getState();
        System.out.println(threadState2);

    }
}
