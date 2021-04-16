package lecture;

import java.lang.reflect.Method;


/**
 * 类加载器的双亲委托模型的好处
 * 1. 可以确保Java核心库的类型安全: 所有的java应用都至少会引用java.lang.object类,也就是说在运行期java.lang.object这个类
 * 会被加载到java虚拟机中; 如果这个加载过程是由java应用自己的类加载器所完成的,那么很可能就会再JVM中存在多个版本的
 * java.lang.Object类,而且这些类之间还是不兼容的,相互不可见的(正是命名空间发挥着作用).
 * 借助于双亲委托机制,java核心类库中的类的加载工作都是由启动类统一完成,从而确保java应用所使用的都是同一个版本的
 * java核心类库,他们之间是相互兼容的.
 * <p>
 * 2. 可以确保java核心类库所提供的类不会被自定义的类所替代.
 * 3. 不同的类加载器可以为相同名称(binary name)的类创建额外的命名空间,相同名称的类可以并存在java虚拟机中,
 * 只需要用不同的类加载器来加载他们即可,不同类加载器所加载的类之间是不兼容的,这就相当于再java虚拟机内部,创建一个又一个相互个理的java
 * 类空间,这类技术再很多框架中得到了实际应用.
 * <p>
 * 不同的类加载器: 两个类加载器不构成父子关系,叫做不同的类加载器
 */

/**
 * @author cjw
 */
public class MyTest21 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\caokw\\Desktop\\JVM_lecture\\target\\classes\\");
        MyTest16 loader2 = new MyTest16("loader2");
        loader2.setPath("C:\\Users\\caokw\\Desktop\\JVM_lecture\\target\\classes\\");
        Class<?> clazz1 = loader1.loadClass("lecture.MyPerson");
        Class<?> clazz2 = loader2.loadClass("lecture.MyPerson");

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", MyPerson.class);
        method.invoke(object1, object2);

        //相同类加载器加载的类实例化的对象能够进行强转,不同类加载器加载的类对象不能进行强转
        MyTest15 myTest15 = new MyTest15();
        objConvert(myTest15);
    }

    private static void objConvert(Object object) {
        MyTest15 myTest15 = new MyTest15();

        myTest15 = (MyTest15)object;
    }
}
