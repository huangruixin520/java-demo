package demo_v1.temp.alibaba;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 多线程之间按顺序调用，实现A->B->C三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * </p>
 *
 * @author ruixin
 * @date 2021/2/27
 */
public class TestDemo03 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyPrintResource myPrintResource = new MyPrintResource();


        executorService.execute(() -> {
            try {
                myPrintResource.printAA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                myPrintResource.printBB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                myPrintResource.printCC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }


    static class MyPrintResource {

        private ReentrantLock lock = new ReentrantLock();
        private Condition c1 = lock.newCondition();
        private Condition c2 = lock.newCondition();
        private Condition c3 = lock.newCondition();

        private int numberFlag = 1;


        public void printAA() throws InterruptedException {

            lock.lock();
            try {
                if (1 != numberFlag) {
                    c1.await();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("AA");
                }
                numberFlag = 2;
                c2.signal();
            } finally {
                lock.unlock();
            }

        }

        public void printBB() throws InterruptedException {

            lock.lock();
            try {
                if (2 != numberFlag) {
                    c2.await();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println("BB");
                }
                numberFlag = 3;
                c3.signal();
            } finally {
                lock.unlock();
            }

        }

        public void printCC() throws InterruptedException {

            lock.lock();
            try {
                if (3 != numberFlag) {
                    c1.await();
                }
                for (int i = 0; i < 15; i++) {
                    System.out.println("CC");
                }
                numberFlag = 1;
                c1.signal();
            } finally {
                lock.unlock();
            }

        }


    }
}
