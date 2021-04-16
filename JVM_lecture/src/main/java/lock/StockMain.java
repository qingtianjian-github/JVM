package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cjw
 */
public class StockMain {

    private static Lock lock = new ReentrantLock();

    static class StockThread implements Runnable {

        @Override
        public void run() {
            boolean b = false;

            //上锁
            lock.lock();
            try {
                //调用减少库存方法
                b = new Stock().reduceStock();
            } finally {
                //解锁
                lock.unlock();
            }

            if (b) {
                System.out.println(Thread.currentThread().getName() + "减少库存成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "减少库存失败");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new StockThread(), "线程1").start();
        new Thread(new StockThread(), "线程2").start();
    }

}
