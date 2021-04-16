package lecture;

/**
 * @author cjw
 */
public class MyTest13 {

    public static void main(String[] args) {
        //获取系统类加载
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);

        while (classLoader != null) {
            classLoader = classLoader.getParent();

            System.out.println(classLoader);
        }
    }



}
