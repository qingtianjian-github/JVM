package lecture;

/**
 * 关于命名空间的重要说明
 *  1: 子加载器所加载的类是能够访问到父加载器所加载的类
 *  2: 父加载器所加载的类无法访问到子加载器所加载的类
 *
 *  双亲委托机制的局限性
 *
 *
 * @author cjw
 */
public class MyTest17_1 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\caokw\\Desktop\\JVM_lecture\\target\\classes\\");

        Class<?> clazz = loader1.loadClass("lecture.MySample");

        System.out.println("class: " + clazz.hashCode());

        Object object = clazz.newInstance();

        System.out.println("object:" + object);

        //如果注释掉该行,那么并不会实例化MySample对象,即MySample构造方法不会被调用
        //因此不会实例化MyCat对象,即没有对MyCat进行主动使用,这里就不会加载MyCat Class
        //Object object = clazz.newInstance();
    }
}
