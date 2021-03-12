package demo_v1.temp.datastructure;

import java.util.Stack;

/**
 * <p>
 *   单链表
 *   注：链表的头节点不存储数据
 * </p>
 *
 * @author ruixin
 * @date 2020-03-18
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", " 及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);


        singleLinkedList.reverse();
        singleLinkedList.list();

    }






}



class SingleLinkedList{

    //定义一个头节点
    HeroNode head =  new HeroNode(0,"","");

    /**
     * 从尾到头打印链表
     * 解：1、先将链表反转，然后遍历
     *    2、利用栈实现
     */
    public void reversePrint(){

        Stack<HeroNode> stacks = new Stack<HeroNode>();

        HeroNode cur = head.next;
        while (cur!=null){

            stacks.push(cur);
            cur=cur.next;
        }

        while (stacks.size()>0){
            System.out.println(stacks.pop());
        }

    }

    /**
     * 链表反转
     * 解：1、头插法： 新建1个头节点，然后依次遍历旧链表，将节点取出，在新链接的头节点后插入
     */
    public void reverse(){

        //定义1个新的链表头节点
        HeroNode newHead = new HeroNode(0, "", "");

        HeroNode cur = head.next;
        HeroNode next =null;

        while (cur!=null){
            next=cur.next;
            cur.next=newHead.next;
            newHead.next=cur;
            cur=next;
        }
        //把新链表头送给原链表的头
        head.next=newHead.next;
    }

    //添加
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if(temp.next==null){
               break;
            }
            temp = temp.next;
        }
        //找到最后一个节点(temp)之后，开始添加节点
        temp.next = heroNode;
    }

    //展示
    public void list(){
        //判空处理
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //开始遍历
        HeroNode temp = head;
        while (temp.next!=null){
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    //修改
    public void updateByNo(int no,String name,String nickName){
        HeroNode temp = head;
        while (true){
            if(temp==null){
                System.out.println("未找到该编号");
                break;
            }
            if(temp.getNo()==no){
                temp.setName(name);
                temp.setNickName(nickName);
                break;
            }
            temp = temp.next;
        }
    }

    //删除
    public void deleteByNo(int no){
        HeroNode temp = head;
        while (true){
            if(temp==null){
                System.out.println("未找到该编号");
                break;
            }
            if(temp.next.getNo()==no){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }


}

/**
 * 链表节点
 */
class HeroNode {

    private int no;

    private String name;

    private String nickName;

    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode() {
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}