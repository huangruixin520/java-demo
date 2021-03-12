package demo_v1.temp.juc;

import org.springframework.beans.factory.FactoryBean;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *   临时demo
 * </p>
 *
 * @author ruixin
 * @date 2020-04-04
 */
public class VolatileDemo2 {

    private static volatile boolean flag = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("start");
                flag = true;
                System.out.println("end");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2--start");
                while (!flag) {
                    System.out.println("t2...while().....");
                }

            }
        });

        t1.start();
//        try {
//            TimeUnit.MILLISECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t2.start();
    }
}

