package com.shengsiyuan.jvm.gc;

/**
 * PSYoungGen: 新生代并行的垃圾收集器
 * ParOldGen: 老年代并行的垃圾收集器
 *
 * @author cjw
 */
public class MyTest1 {

    public static void main(String[] args) {
        //1M = 1024k.
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[3 * size];
        byte[] myAlloc2 = new byte[3 * size];
        byte[] myAlloc3 = new byte[3 * size];
        byte[] myAlloc4 = new byte[3 * size];

        System.out.println("hello world");
    }
}
