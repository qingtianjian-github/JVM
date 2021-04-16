package com.shengsiyuan.jvm.bytecode;

import java.io.Serializable;

/**
 * 现代JVM在执行java代码的时候,通常都会将解释执行和编译执行将二者结合起来进行.
 * <p>
 * 所谓解释执行,就是通过解释器来读取字节码,遇到相应的指令就去执行该指令
 * 所谓编译执行,是通过即时编译器(JUST IN TIME, JIT)将字节码转换为本地机器码来执行;现代JVM会根据代码热点来生成相应的本地机器码.
 * <p>
 * 基于栈的指令集与基于寄存器的指令集之间的关系:
 * 1. JVM执行指令时所采取的方式是基于栈的指令集
 * 2. 基于栈的指令集之遥的操作时入栈与出栈两种.
 * 3. 基于栈的指令集的优势在于它可以在不同平台之间移植.而基于寄存器的指令集是与硬件架构紧密关联的,无法做到可移植.
 * 4. 基于栈的指令集的缺点在于完成相同的操作,指令数量通常要比基于寄存器的指令集数量要多; 基于栈的指令集是在内存中的完成操作的,
 * 而基于寄存器的指令集时直接由CPU来执行的,他是在高速缓冲区进行执行的,速度要快很多.虽然虚拟机可以采用一些优化手段,
 * 但总体来说,基于栈的指令集的执行速度要慢一些.
 *
 * @author cjw
 */
public class MyTest8 implements Serializable {

    public int myCalculate() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;

        int result = (a + b - c) * d;

        return result;
    }

}
