package demo_v1.temp.datastructure;

/**
 * <p>
 *   临时执行空间
 * </p>
 *
 * @author ruixin
 * @date 2020-08-24
 */
public class MergeSortedSingleLinkedListDemo {



    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        l1.next = listNode2;
        listNode2.next= listNode4;


        ListNode l2 = new ListNode(1);
        ListNode l2with3 = new ListNode(3);
        ListNode l2with4 = new ListNode(4);
        l2.next = l2with3;
        l2with3.next=l2with4;



        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(l1, l2);
        System.out.println(listNode);



    }


}

class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newHead = new ListNode(0);
        ListNode newCur =newHead;

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1!=null && cur2!=null){

            if(cur1.val<cur2.val){

                newCur.next = cur1;

                cur1 = cur1.next;

            }else {

                newCur.next = cur2;

                cur2 = cur2.next;
            }
            newCur = newCur.next;
        }
        newCur.next=cur1==null ?cur2:cur1;
        return newHead.next;
    }

}

//class TestDemo {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(0);
//        ListNode pre = head;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                head.next = l1;
//                l1 = l1.next;
//            } else {
//                head.next = l2;
//                l2 = l2.next;
//            }
//            head = head.next;
//        }
//        head.next = l1 == null ? l2 : l1;
//        return pre.next;
//    }
//}
