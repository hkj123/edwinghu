package com.springboot.mybatis.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController   //注意模板 需要这个
public class ThreadController extends BaseController {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start(); // 启动新线程

        Thread t1 = new Thread(new MyRunnable());
        t1.start(); // 启动新线程

        Thread t2 = new Thread(() -> {
            System.out.println("线程thread lambda写法");
        });
        t2.start(); // 启动新线程

        System.out.println("main start...");
        Thread t3 = new Thread() {
            public void run() {
                System.out.println("thread run...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("thread end.");
            }
        };
        t3.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}
        System.out.println("main end...");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程thread extends Thread");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程thread implements Runnable");
    }
}