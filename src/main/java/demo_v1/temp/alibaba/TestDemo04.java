package demo_v1.temp.alibaba;



/**
 * <p>
 * 实现函数,给定一个字符数组,求该数组的连续非空子集，分別打印出来各子集 ，
 * 举例数组为[abc]，输出[a],[b],[c],[ab],[bc],[abc]
 * </p>
 *
 * @author ruixin
 * @date 2021/2/28
 */
public class TestDemo04 {

    public static void main(String[] args) {
        char[] chars = new char[]{'a','b','c'};
        printChar(chars);
    }

    public static void printChar(char[] chars) {

        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(chars[i]);
            System.out.println(sb);
            //i不是c的时候，就对每一个for循环的字符不要停 如果for循环的是b，那么就一直输出bc、cd....
            int n=i;
            while (n != (chars.length - 1)) {
                n = ++n;
                sb.append(chars[n]);
                System.out.println(sb);
            }
        }
    }

}
