package demo_v1.temp.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-03-28
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        MyTask myTask = new MyTask();
        for(int i=0;i<20;i++){
            es.submit(myTask);
        }


    }

    static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
