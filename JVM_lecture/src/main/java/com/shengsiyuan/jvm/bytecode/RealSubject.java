package com.shengsiyuan.jvm.bytecode;

/**
 * @author cjw
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("From real subject");
    }
}
