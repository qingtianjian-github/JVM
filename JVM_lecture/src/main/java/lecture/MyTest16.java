package lecture;

import java.io.*;

/**
 * @author cjw
 */
public class MyTest16 extends ClassLoader {

    //类加载器名称
    private String classLoaderName;

    //从当前工程加载
    private String path;

    private final String fileExtension = ".class";

    public MyTest16(ClassLoader parent){
        super(parent);
    }

    public MyTest16(String classLoaderName) {
        super();//将系统类加载器当作该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);// 显式指定类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    /**
     * 寻找类,返回对象
     *
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked: " + className);

        System.out.println("class loader name: " + this.classLoaderName);

        byte[] data = this.loadClassData(className);

        return this.defineClass(className, data, 0, data.length);
    }

    /**
     * 加载类的二进制名字
     */
    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        name = name.replace(".", "\\");

        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");

            is = new FileInputStream(new File(this.path + name + this.fileExtension));

            baos = new ByteArrayOutputStream();

            int ch = 0;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        //loader1.setPath("D:\\workspace\\JVM_lecture\\target\\classes");
        loader1.setPath("C:\\Users\\caokw\\Desktop\\JVM_lecture\\target\\classes\\");

        //Class<?> clazz = loader1.loadClass("lecture.MyTest15");
        Class<?> clazz = loader1.loadClass("lecture.MyTest15");

        System.out.println("clazz: " + clazz.hashCode());

        Object object = clazz.newInstance();

        System.out.println("object: " + object.hashCode());

        loader1 = null;
        clazz = null;
        object = null;

        System.gc();

        Thread.sleep(2000000);


        loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\caokw\\Desktop\\JVM_lecture\\target\\classes\\");
        clazz = loader1.loadClass("lecture.MyTest15");

        System.out.println("clazz: " + clazz.hashCode());

        object = clazz.newInstance();

        System.out.println("object: " + object.hashCode());


        //test(loader1);

        /*MyTest16 loader2 = new MyTest16(loader1, "loader2");
        loader2.setPath("C:\\Users\\caokw\\Desktop\\JVM_lecture\\target\\classes\\");
        Class<?> clazz2 = loader2.loadClass("lecture.MyTest15");

        System.out.println("clazz2: " + clazz2.hashCode());

        Object object2 = clazz2.newInstance();

        System.out.println("object2: " + object2.hashCode());


        MyTest16 loader3 = new MyTest16(loader2, "loader3");
        loader3.setPath("C:\\Users\\caokw\\Desktop\\JVM_lecture\\target\\classes\\");
        Class<?> clazz3 = loader3.loadClass("lecture.MyTest15");

        System.out.println("clazz3: " + clazz3.hashCode());

        Object object3 = clazz3.newInstance();

        System.out.println("object3: " + object3.hashCode());*/

    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("lecture.MyTest15");
        Object object = clazz.newInstance();

        System.out.println(object);
        System.out.println("classLoader:" + object.getClass().getClassLoader());

    }
}
