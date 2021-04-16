package lecture;

/**
 * @author cjw
 */
public class MySample {

    public MySample() {
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());

        new MyCat();

        System.out.println("from MyCat: " + MyCat.class);
    }
}
