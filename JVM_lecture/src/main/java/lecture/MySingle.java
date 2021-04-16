package lecture;

/**
 * @author cjw
 */
public class MySingle {

    public static int a;

    private static MySingle mySingle = new MySingle();

    public MySingle() {
        a++;
        b++;
    }

    public static int b = 0;

    public static MySingle newInstance() {
        return mySingle;
    }
}
