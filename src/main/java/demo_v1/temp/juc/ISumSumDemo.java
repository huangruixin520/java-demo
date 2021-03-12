package demo_v1.temp.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-03-23
 */
public class ISumSumDemo {

    public static void main(String[] args) {

        Task task = new Task();
        for(int i=0;i<20;i++){
            new Thread(task).start();
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i结果："+task.getResult());
    }

    static class Task implements Runnable{
        Integer result = 0;

        @Override
        public void run() {
            result++;
        }

        public Integer getResult(){
            return result;
        }
    }
}
