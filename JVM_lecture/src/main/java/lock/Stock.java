package lock;

/**
 * @author cjw
 */
public class Stock {

    /**
     * 库存数量
     */
    private static int num = 1;

    public static void main(String[] args) {

    }

    public boolean reduceStock() {
        if (num > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num--;
            return true;
        } else {
            return false;
        }
    }
}
