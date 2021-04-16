package lecture;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 分析清楚
 *
 * @author cjw
 */
public class MyTest27 {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("1", "username", "password");

    }
}
