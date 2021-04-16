package lecture;

/**
 * 在运行期,一个java类是由该类的完全限定名(binary name 二进制)和用于加载该类的定义类加载器(defining loader)所共同决定的.
 * 如果同样名字(即相同的完全限定名)的类是由两个不同的类加载器所加载,那么这些类就是不同的,即便.class文件的字节码完全一样,并且从相同的
 * 加载亦如此.
 * <p>
 * 再Oracle的Hotsport实现中,系统属性sun.boot.class.path如果改错了,则运行会出错,提示如下错误信息:
 * <p>
 * Error occurred during initialization of VM
 * java/lang/NoClassDefFoundError: java/lang/Object
 */

import sun.misc.Launcher;

/**
 * @author cjw
 */
public class MyTest23 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        /*
        内建于JVM中的启动类加载器会加载java.lang.ClassLoader以及其他的java平台类,
        当JVM启动时,一块特殊的机器码会运行,它会加载扩展类加载器与系统类加载器,
        这块特殊的机器码叫做启动类加载器

        启动类加载器不是java类,二其他的类加载器都是java类
        启动类加载器是特定于平台的机器指令,她负责开始整个加载过程

        所有类加载器(除了启动类加载器)都被实现为jiava类,不过,总归要有一个组件来加载第一个java类加载器,从而让整个加载过程能够顺利
        进行下去,加载第一个纯java类加载器就是启动类加载器的职责.

        启动类加载器还会负责加载供JRE正常要运行所需要的基本组件,这包括java.util与java.lang等等
         */
        //ClassLoader是java类的类加载器
        System.out.println(ClassLoader.class.getClassLoader());

        //扩展类加载器与系统类加载器也是由启动类加载器所加载的
        System.out.println(Launcher.class.getClassLoader());


        System.out.println("-----------------------------");


        System.out.println(System.getProperty("java.System.class.loader"));

        System.out.println(MyTest23.class.getClassLoader());

        System.out.println(MyTest16.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
