package com.shengsiyuan.jvm.gc;

/**
 * @author cjw
 */
public class MyTest4 {

    public static void main(String[] args) throws InterruptedException {
        byte[] byte_1 = new byte[512 * 1024];
        byte[] byte_2 = new byte[512 * 1024];

        myGc();
        Thread.sleep(1000);

        System.out.println("111111");

        myGc();
        Thread.sleep(1000);

        System.out.println("222222");

        myGc();
        Thread.sleep(1000);

        System.out.println("333333");

        myGc();
        Thread.sleep(1000);

        System.out.println("444444");
    }

    private static void myGc() {
        for (int i = 0; i < 40; i++) {
            byte[] byteArray = new byte[1024 * 1024];
        }
    }
}
