package lecture;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author cjw
 */
public class MyTest14 {

    public static void main(String[] args) throws IOException {
        //获取当前线程上下文类加载器
        //由当前线程的创建者提供的,在不进行设置的情况下
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String resourceName = "lecture/MyTest13.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("------------");


        Class<MyTest14> myTest14Class = MyTest14.class;

        System.out.println(myTest14Class.getClassLoader());
    }
}
