package com.springboot.mybatis.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//New：新创建的线程，尚未执行；
//Runnable：运行中的线程，正在执行run()方法的Java代码；
//Blocked：运行中的线程，因为某些操作被阻塞而挂起；
//Waiting：运行中的线程，因为某些操作在等待中；
//Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
//Terminated：线程已终止，因为run()方法执行完毕
@RestController   //注意模板 需要这个
public class ThreadController extends BaseController {
    public static void main(String[] args) throws Exception {
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

//        java.util.concurrent 包类详解
        Counter t4 = new Counter();
        t4.add(1);
    }
    int min = 4;
    int max = 10;
    ExecutorService es = new ThreadPoolExecutor(min, max,
            60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
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

class Counter{
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) throws Exception{
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                count += n;
            } finally {
                lock.unlock();
            }
        }
    }
}