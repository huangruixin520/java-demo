package demo_v1.temp.jvm.classloader;

/**
 * 类加载器
 */
public class TestJDKClassLoader {

    public static void main(String[] args){
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
    }
}
