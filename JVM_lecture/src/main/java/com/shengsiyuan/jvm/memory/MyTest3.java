package com.shengsiyuan.jvm.memory;

/**
 * @author cjw
 */
public class MyTest3 {

    public static void main(String[] args) {
        Runnable reA = new Runnable() {
            @Override
            public void run() {
                A.method();
            }
        };

        Runnable reB = new Runnable() {
            @Override
            public void run() {
                B.method();
            }
        };

        new Thread(reA, "Thread-A").start();
        new Thread(reB, "Thread-B").start();

        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class A {

    public static synchronized void method() {
        System.out.println("method from A");

        try {
            Thread.sleep(5000);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B {

    public static synchronized void method() {
        System.out.println("method from B");

        try {
            Thread.sleep(5000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



