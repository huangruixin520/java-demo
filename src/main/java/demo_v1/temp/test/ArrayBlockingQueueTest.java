package demo_v1.temp.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *   数组有界阻塞队列
 * </p>
 *
 * @author ruixin
 * @date 2020-08-20
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws Exception {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);
        ShareResource shareResource = new ShareResource(blockingQueue);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    shareResource.prod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    shareResource.concumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者线程").start();

        TimeUnit.SECONDS.sleep(60);
        System.err.println("60s后，main线程开始喊停生产者和消费者线程.....");
        shareResource.stop();

    }
}


class ShareResource{

    private BlockingQueue<String> blockingQueue = null;

    private volatile boolean flag = true;

    private AtomicInteger number = new AtomicInteger(0);

    public ShareResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    public void prod() throws InterruptedException {
        String data = null;
        while (flag){
            data = number.incrementAndGet()+"";
            blockingQueue.put(data);
            if(data!=null){
                System.out.println(Thread.currentThread().getName()+"生产成功："+data);
            }else {
                System.err.println(Thread.currentThread().getName()+"生产失败");
            }
            //concumer线程在poll()之后还没有打印消费成功，生产者就开始存了，导致打印顺序有问题，但不会产生线程不安全问题
            //所以睡眠一会儿
//            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void concumer() throws InterruptedException {
        while (flag){
            //prod线程在offer()之后还没有打印生产成功，消费者就开始取了，导致打印顺序有问题，但不会产生线程不安全问题
            //所以睡眠一会儿
//            TimeUnit.SECONDS.sleep(1);
            String result = blockingQueue.take();
            if(null==result){
                System.err.println(Thread.currentThread().getName()+"消费失败");
            }
            System.out.println("-->"+Thread.currentThread().getName()+"消费成功："+result);
        }
    }

    public void stop(){
        flag =false;
    }
}