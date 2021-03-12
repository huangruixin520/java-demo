package demo_v1.temp.exam;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-04-01
 */
public class StringDemo {
    public static void main(String[] args) {


        String s1 = "abc";
        String s2 = new String("abc");
        String s3= "a";
        String s4 ="bc";
        String s5=s3+s4;

        System.out.println(s1==s2);
        System.out.println(s1==s5);
        System.out.println(s1);
        System.out.println(s5);
    }
}
