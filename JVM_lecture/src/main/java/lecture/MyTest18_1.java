package lecture;

/**
 * @author cjw
 */
public class MyTest18_1 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\caokw\\Desktop\\JVM_lecture\\target\\classes\\");
        Class<?> clazz = loader1.loadClass("lecture.MyTest15");

        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader name: " + clazz.getClassLoader());
    }
}
