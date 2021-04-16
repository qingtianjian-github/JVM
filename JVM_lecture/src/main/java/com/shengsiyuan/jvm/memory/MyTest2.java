package com.shengsiyuan.jvm.memory;

/**
 * 虚拟机栈溢出
 *
 * @author cjw
 */
public class MyTest2 {

    private int length;

    public int getLength() {
        return length;
    }

    public void test() {
        this.length++;

        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();

        try {
            myTest2.test();
        } catch (Exception e) {
            System.out.println(MyTest2.class);
            e.printStackTrace();
        }
    }
}
