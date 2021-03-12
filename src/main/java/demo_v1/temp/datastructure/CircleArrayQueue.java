package demo_v1.temp.datastructure;

import java.util.Scanner;

//使用数组模拟队列——编写一个ArrayQueue类
class CircleArrayQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列的第一个元素
    private int rear; // 队列的最后一个元素的后一个位置
    private int[] arr; // 该数组用于存放数据

    // 创建队列的构造器
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        // 直接将数据加入
        arr[rear] = n;
        rear = (rear + 1) % maxSize;// 将rear后移，必须考虑取模(当rear指向最后时，可以通过取模将rear指向队列起始位置)
    }

    // 获取队列的数据
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("队列空，不能取出数据");
        }
        // 需要分析出front是指向队列的第一个元素
        // 1、先把front对应的值保存到一个临时变量中
        int value = arr[front];
        // 2、将front后移，考虑取模
        front = (front + 1) % maxSize;
        // 3、将临时保存的变量返回
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        // 从front开始遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("%d\t", arr[i % maxSize]);
        }
    }

    // 求出当前队列有效数据个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }


    public static void main(String[] args) {
        // 创建一个队列
        CircleArrayQueue arrayQueue = new CircleArrayQueue(3);
        int key;// 接收用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println();
            System.out.println("1:显示队列");
            System.out.println("2:添加数据到队列");
            System.out.println("3:从队列获取数据");
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
