package com.shengsiyuan.jvm.bytecode;

/**
 * 方法的动态分派:
 *
 *  方法的动态分派涉及到一个重要的概念: 方法接收者.
 *
 *
 *  invokevirtual: 字节码指定的多态查找的流程
 *
 *  比较方法重载与方法重写,我们可以得到这样一个结论,
 *
 *  方法重载是静态的,是编译器行为;方法重写是动态的,是运行期行为.
 *
 *  1: 找到操作数栈顶的第一个元素,所指向对象的实际类型,如果在实际类型与常量池当中的方法描述符和方法名称相同的类型和方法,访问权校验通过,
 *
 *
 *
 * @author cjw
 */
public class MyTest6 {

    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit {

    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {

    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {

    @Override
    public void test() {
        System.out.println("Orange");
    }
}