package lecture;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * 演示扩展类加载器
 *
 * @author cjw
 */
public class MyTest19 {

    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        ClassLoader classLoader = aesKeyGenerator.getClass().getClassLoader();

        System.out.println("AESKeyGenerator loader: "+classLoader);
        System.out.println("MyTest19 loader: "+ MyTest19.class.getClassLoader());
    }
}
