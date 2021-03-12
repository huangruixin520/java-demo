package demo_v1.temp.datastructure.tree;

/**
 * <p>
 *   二叉排序树--二叉查找树
 * </p>
 *
 * @author ruixin
 * @date 2020-09-02
 */
public class BinarySortedTreeDemo {
    public static void main(String[] args) {

    }
}

class SortNode{

    public int value;

    public SortNode left;

    public SortNode right;

    public SortNode(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "SortNode{" +
                "value=" + value +
                '}';
    }
}
