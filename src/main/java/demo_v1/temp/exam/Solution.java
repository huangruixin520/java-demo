package demo_v1.temp.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-07-12
 */
class Solution {

    public static int[] reversePrint(ListNode head) {
        // 首先遍历链表来获取链表的长度值
        ListNode currentNode = head;
        int len = 0;
        while(currentNode!=null){
            len++;
            currentNode = currentNode.next;
        }
        int [] result = new int[len];
        System.err.println("len:"+len);
        for(int i = len - 1;i >=0; i--){
            result[i] = head.val;
            head = head.next;
        }
        return result;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        head.next=listNode2;
        listNode2.next=listNode3;

        int[] reversePrint = reversePrint(head);
        System.err.println(Arrays.toString(reversePrint));

        ReentrantLock reentrantLock = new ReentrantLock();




    }

}

class ListNode{

     int val;

     ListNode next;

     ListNode(int x) {
         val = x;
     }
}