package demo_v1.temp.datastructure.tree;

/**
 * <p>
 *  二叉树的遍历
 * </p>
 *
 * @author ruixin
 * @date 2020-09-01
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(1,"宋江");
        Node node2 = new Node(2,"吴用");
        Node node3 = new Node(3,"卢俊义");
        Node node4 = new Node(4,"林冲");
        Node node5 = new Node(5,"关胜");

        root.left = node2;
        root.right = node3;
        node3.right = node4;
        node3.left = node5;

        binaryTree.setNode(root);

        //前序遍历
        System.out.println("前序遍历");
        binaryTree.preOrderPrint();
        //中序遍历
        System.out.println("中序遍历");
        binaryTree.mediumOrderPrint();
        //后序遍历
        System.out.println("后序遍历");
        binaryTree.postOrderPrint();

        //前序遍历查找
        System.out.println("前序遍历查找");
        Node result = binaryTree.preOrderSearch(3);
        System.out.println(result);

        //删除节点
        System.out.println("删除节点");
        binaryTree.delNode(3);



    }

}


class BinaryTree{

    private Node root;

    public void setNode(Node root) {
        this.root = root;
    }

    public void preOrderPrint(){
        this.root.preOrder();
    }

    public void mediumOrderPrint(){
        this.root.mediumOrder();
    }

    public void postOrderPrint(){
        this.root.postOrder();
    }

    //查询
    public Node preOrderSearch(int no){
        return this.root.preOrderSearch(no);
    }

    //删除节点
    public void delNode(int no){
        this.root.delNode(no);
    }

}

class Node{

    public int no;

    public String name;

    public Node left;

    public Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder(){

        System.out.println(this);

        if(this.left!=null){
            this.left.preOrder();
        }

        if(this.right!=null){
            this.right.preOrder();
        }
    }

    public void mediumOrder(){

        if(this.left!=null){
            this.left.mediumOrder();
        }

        System.out.println(this);

        if(this.right!=null){
            this.right.mediumOrder();
        }
    }

    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }


    public Node preOrderSearch(int no){

        if(this.no==no){
            return this;
        }

        Node node =null;
        if(this.left!=null){
            node = this.left.preOrderSearch(no);
        }

        if(node!=null){
            return node;
        }
        if(this.right!=null){
            node = this.right.preOrderSearch(no);
        }
        return node;
    }

    public void delNode(int no){

        if(this.left!=null && this.left.no==no){
            this.left = null;
            return;
        }
        if(this.right!=null && this.right.no==no){
            this.right = null;
            return;
        }

        if(this.left!=null){
            this.left.delNode(no);
        }
        if(this.right!=null){
            this.right.delNode(no);
        }
    }

}
