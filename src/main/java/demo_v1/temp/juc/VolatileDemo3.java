package demo_v1.temp.juc;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *   volatile不保证原子性证明
 * </p>
 *
 * @author ruixin
 * @date 2020-04-08
 */
public class VolatileDemo3 {

    private static volatile int a = 0;

    private static Object obj = new Object();

    public static void main(String[] args) {

        for(int i=0;i<10;i++){

            Thread t = new Thread(() -> {
                for(int j=0;j<10000;j++){
                    a++;
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
