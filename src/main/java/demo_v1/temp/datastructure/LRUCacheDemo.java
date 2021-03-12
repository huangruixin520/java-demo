package demo_v1.temp.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  手写LRU算法
 * </p>
 *
 * @author ruixin
 * @date 2021-01-18
 */
public class LRUCacheDemo {

    //1、构造一个Node节点类
    class Node<K,V>{
        public K key;
        public V value;
        public Node<K,V> next;
        public Node<K,V> prev;
        public Node() {
            this.next = null;
            this.prev = null;
        }
        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    //2、构造一个双向链表
    class DoubleLinkedList<K,V>{

        public Node<K,V> head;
        public Node<K,V> tail;

        //2.1: 链表构造器
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        //2.1: 添加节点
        public void addHead(Node<K,V> node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        //2.1: 删除节点
        public void removeNode(Node<K,V> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = null;
            node.prev = null;
        }

        public Node<K,V> getLast(){
            return tail.prev;
        }
    }

    //3、定义LRU基本属性   lru大小size、map、双向链表对象
    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public LRUCacheDemo(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList<>();
    }


    public int get(int key){

        if(!map.containsKey(key)){
            return -1;
        }
        doubleLinkedList.removeNode(map.get(key));
        doubleLinkedList.addHead(map.get(key));
        System.err.println(doubleLinkedList);
        return map.get(key).value;
    }

    public void put(int key,int value){

        if(map.containsKey(key)){

            Node<Integer, Integer> oldNode = map.get(key);
            oldNode.value = value;
            doubleLinkedList.removeNode(oldNode);
            doubleLinkedList.addHead(oldNode);
        }else {

            if(cacheSize==map.size()){
                Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
                doubleLinkedList.removeNode(lastNode);
                map.remove(lastNode.key);
            }
            Node<Integer, Integer> newNode = new Node<>(key, value);
            doubleLinkedList.addHead(newNode);
            map.put(key,newNode);
        }
    }



    public static void main(String[] args) {


        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);

        lruCacheDemo.put(7,1);
        lruCacheDemo.put(5,2);
        lruCacheDemo.put(3,3);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(3,2);
        System.out.println(lruCacheDemo.map.keySet());

    }
}
