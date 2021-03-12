package demo_v1.temp.datastructure;

import java.util.Scanner;

//使用数组模拟队列——编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数组用于存放数据

    // 创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部(指向的是队列头的前一个位置)
        rear = -1;// 指向队列尾部(指向的是队列尾的数据)
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;// 让rear后移
        arr[rear] = n;
    }

    // 获取队列的数据
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("队列空，不能取出数据");
        }
        front++;// 让front后移
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i : arr) {
            System.out.printf("%d\t", i);
        }
    }


    public static void main(String[] args) {
        // 创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        int key;// 接收用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println();
            System.err.println("1:显示队列");
            System.err.println("2:添加数据到队列");
            System.err.println("3:取出队列数据");
            key = sc.nextInt();// 接收一个字符
            switch (key) {
                case 1:
                    arrayQueue.showQueue();
                    break;
                case 2:
                    System.out.println("输入一个数:");
                    int value = sc.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 3:
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据是:" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
