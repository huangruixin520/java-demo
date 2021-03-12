package demo_v1.temp.exam;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-03-28
 */
public class TestObject {
    public static void main(String[] args) {
        String[] strs = new String[2];
        Object[] objs =strs;
        strs[0] = "hi";
        objs[1] =Integer.valueOf(42);
    }
}
