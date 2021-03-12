package demo_v1.temp.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-04-08
 */
public class VolatileDemo4 {

    private static  AtomicInteger a = new AtomicInteger(0);

    public static void main(String[] args) {

        for(int i=0;i<10;i++){

            Thread t = new Thread(() -> {
                for(int j=0;j<1000000;j++){
                    a.getAndIncrement();
                }
            });
            t.start();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("a:-->"+a);

    }
}
