package demo_v1.temp.alibaba;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 有3个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向数组输出l，线程3的功能就是向数组输出i。
 * 要求按顺序向数组赋值AliAliAli，Ali的个数由线程A函数的参数指定
 * </p>
 *
 * @author ruixin
 * @date 2021/2/27
 */
public class TestDemo02 {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CountDownLatch countDownLatch = new CountDownLatch(3);
        MyResource myResource = new MyResource(6, countDownLatch);

        executorService.execute(() -> {
            try {
                myResource.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                myResource.printL();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                myResource.printI();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        countDownLatch.await();
        StringBuilder sb = new StringBuilder();
        for (String s : myResource.getList()) {
            sb.append(s);
        }
        System.out.println(sb.toString());
        executorService.shutdown();

    }

    static class MyResource {

        public List<String> pubCharArr = new ArrayList<>();

        private int n;


        private ReentrantLock lock = new ReentrantLock();

        private Condition c1 = lock.newCondition();
        private Condition c2 = lock.newCondition();
        private Condition c3 = lock.newCondition();

        private int flag = 1;

        private CountDownLatch countDownLatch;

        public MyResource(int n, CountDownLatch countDownLatch) {
            this.n = n;
            this.countDownLatch = countDownLatch;
        }

        public void printA() throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                System.err.println("A抢到锁");
                if (flag != 1) {
                    c1.await();
                }
                try {
                    pubCharArr.add("A");
                    flag = 2;
                    c2.signal();
                } finally {
                    lock.unlock();
                    System.err.println("A释放锁");
                }
            }
            countDownLatch.countDown();
        }

        public void printL() throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                System.err.println("L抢到锁");
                if (flag != 2) {
                    c2.await();
                }
                try {
                    pubCharArr.add("l");
                    flag = 3;
                    c3.signal();
                } finally {
                    lock.unlock();
                    System.err.println("L释放锁");
                }
            }
            countDownLatch.countDown();
        }

        public void printI() throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                System.err.println("I抢到锁");
                if (flag != 3) {
                    c3.await();
                }
                try {
                    pubCharArr.add("i");
                    flag = 1;
                    c1.signal();
                } finally {
                    lock.unlock();
                    System.err.println("I释放锁");
                }
            }
            countDownLatch.countDown();
        }

        public List<String> getList() {
            return pubCharArr;
        }

    }


}







