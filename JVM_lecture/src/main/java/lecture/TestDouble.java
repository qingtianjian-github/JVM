package lecture;

import java.math.BigDecimal;

/**
 * @author cjw
 */
public class TestDouble {

    public static void main(String[] args) {
        double a = 1;
        double b = 20.2;
        double c = 300.03;

        double v = a + b;

        System.out.println(v);

        double v1 = a + c;

        System.out.println(v1);

        double v2 = b + c;

        System.out.println(v2);

        double result = +1 + 20.2 + 300.03;

        //预计结果是321.23
        System.out.println("审计结果:" + result);


        double d = 301353.05;
        BigDecimal decimal1 = new BigDecimal(d);
        System.out.println(decimal1);
        //String string = Double.toString(d);
        //BigDecimal decimal = new BigDecimal(string);
        BigDecimal bigDecimal = BigDecimal.valueOf(d);
        System.out.println(bigDecimal);

    }
}
