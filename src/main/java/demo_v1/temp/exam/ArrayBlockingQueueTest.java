package demo_v1.temp.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-03-28
 */
public class ArrayBlockingQueueTest {


    public static void main(String[] args) {

         ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);
         blockingQueue.add(1);
         blockingQueue.add(2);
        try {
            for (int i=0;i<=blockingQueue.size();i++){
                System.out.println(blockingQueue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<String,String> map =new HashMap();
        map.put("key","helloworld");

    }
}
