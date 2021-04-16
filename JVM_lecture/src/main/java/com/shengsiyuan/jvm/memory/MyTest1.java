package com.shengsiyuan.jvm.memory;

import java.util.HashMap;
import java.util.Map;

/**
 * Stack Frame 栈帧
 * 程序计数器 (Program Counter)
 * 本地方法栈: 主要用于处理本地方法
 * 堆 (Heap): JVM管理的最大一块内存空间,与堆相关的一个重要概念是垃圾收集器.现在几乎所有的垃圾回收算法都是采用的分代收集算法.
 * 所以,堆空间也给予这一点进行了相应划分: 新生代与老年代.Eden空间,From Survivor空间与To Survivor空间.
 * 方法区 (Method Area): 存储元数据信息.永久代 (Permanent Generation),从JDK1.8开始,已经彻底废弃了永久代.使用元空间
 * (mate space)
 * 运行时常量池: 方法区的一部分内容.
 * 直接内存: Direct Memory,与Java NIO密切相关.JVM通过DirectByteBuffer来操作直接内存.
 *
 * 关于java对象创建的过程:
 *
 * new关键字创建对象的3个步骤:
 *  1. 在堆内存中创建对象的实例
 *  2. 为对象的实例成员变量赋初始值
 *  3. 将对象的引用返回
 *
 * 指针碰撞:前提是堆中的空间通过一个指针进行分割,一侧是已经被占用的空间,另一侧是未被占用的空间.
 * 空闲列表: 前提是堆内存空间中已被使用与未被使用的空间交织在一起的,这时,虚拟机就需要通过一个列表来记录哪些空间是可以使用的.那些空间是一杯使用的.
 *  接下来这出可以容纳下新创建对象的且未被使用的空间,再次空间存放该对象,同时还要修改列表上的记录.
 *
 *  对象再内存中的布局;
 *   1. 对象头
 *   2. 实例数据(即我们在一个类种所声明的各项信息)
 *   3. 对齐填充(可选)
 *
 *   引用访问对象的方式:
 *   1. 使用句柄的方式
 *   2. 使用直接指针的方式
 *
 *
 *
 * @author cjw
 */
public class MyTest1 {

    public static void main(String[] args) {
        HashMap map = new HashMap<String,String>();
        map.put("1","1");
        System.out.println("哈哈");
    }
}
