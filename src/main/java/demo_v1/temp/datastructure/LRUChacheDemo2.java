package demo_v1.temp.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  手写lru算法
 * </p>
 *
 * @author ruixin
 * @date 2021/2/27
 */
public class LRUChacheDemo2 {

    public static void main(String[] args) {


    }
}


class LRUContain{

    private DoubleLinkedList doubleLinkedList;
    private Map<Integer,Integer> map;


    public LRUContain(DoubleLinkedList doubleLinkedList,int n) {
        this.doubleLinkedList = doubleLinkedList;
        map = new HashMap<>(n);

    }




    //定义双向链表
    class DoubleLinkedList{

        private Node head;


        public DoubleLinkedList() {
            head = new Node();
        }
    }

    //定义节点
    class Node{

        public int key;
        public int value;
        public Node next;
        public Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}








