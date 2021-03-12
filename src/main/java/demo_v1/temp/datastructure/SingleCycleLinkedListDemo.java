package demo_v1.temp.datastructure;

/**
 * <p>
 *  单向环形链表(约瑟夫环问题)
 * </p>
 *
 * @author ruixin
 * @date 2020-08-26
 */
public class SingleCycleLinkedListDemo {
    public static void main(String[] args) {

        SingleCycleLinkedList singleCycleLinkedList = new SingleCycleLinkedList();

       singleCycleLinkedList.addBoy(125);
       //singleCycleLinkedList.list();

        singleCycleLinkedList.yuesefuProblem(10,20);

    }
}

/**
 * 环形链表
 */
 class SingleCycleLinkedList{

    public Boy first = null;


    /**
     * 约瑟夫问题-解决方案
     * n：共有n个boy
     * k、m：从k开始数，数到第m个，m出去，然后从出去的boy的下一个开始从数，数到m再出列...
     */
    public void yuesefuProblem(int k,int m){

        //k、m参数合法性校验

        //定义辅助指针
        Boy cur = first;
        Boy curFirst = first;
        Boy outBoy = null;

        //
        boolean flag = false;
        int count = 1;
        while (true){
            //定义数数起点
            if(cur.No==k){
                curFirst = cur;
                flag =true;
            }

            if(flag){
                if(count+1==m){
                    //备份待出列的boy
                    outBoy = cur.next;
                    //出列
                    cur.next = cur.next.next;

                    System.out.println("出列boy编号:"+outBoy.No);
                    //重新定位数1的boy
                    curFirst =cur.next;
                    count=0;

                }
                count++;
            }

            if(cur.next==cur){
                System.out.println("最后一个留在圈子里的boy编号:"+cur.No);
                break;
            }

            cur = cur.next;
        }

    }

    /**
     * 添加循环链表
     */
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("num不正确");
            return;
        }
        //指针
        Boy cur = null;
        for (int i=1;i<=nums;i++){
            Boy boy = new Boy(i);
            //当只有1个节点时，那么自己就是环
            if(i==1){
                first = boy;
                first.next=first;
                //移动指针
                cur = first;
            }else {
                cur.next = boy;
                boy.next=first;
                //移动指针
                cur = boy;
            }
        }
    }

    /**
     * 遍历打印循环链表
     */
    public void list(){

        if(first==null){
            System.out.println("环形链表为空");
        }

        //定义指针
        Boy cur = first;
        while (true){
            System.out.println("学生编号:"+cur.No);
            if(cur.next==first){
                break;
            }
            //移动指针
            cur = cur.next;
        }
    }

}


/**
 * 定义链表节点
 */
class Boy{

    public Integer No;

    public Boy next;

    @Override
    public String toString() {
        return "Boy{" +
                "No=" + No +
                '}';
    }

    public Boy(Integer no) {
        No = no;
    }
}
