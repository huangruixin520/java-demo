package demo_v1.temp.juc;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  验证volatile代码示例
 * </p>
 *
 * @author ruixin
 * @date 2020-04-07
 */
public class VolatileDemo {

    private static  boolean flag = true;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start");
                while (flag){

                }
                System.out.println("end");
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;
    }

}
