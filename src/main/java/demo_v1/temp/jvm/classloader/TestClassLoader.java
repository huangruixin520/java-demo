package demo_v1.temp.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * <p>
 *  自定义类加载器
 * </p>
 *
 * @author ruixin
 * @date 2020-03-26
 */
public class TestClassLoader {


    public static void main(String[] args) {

        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Class<?> clazz = Class.forName("Test", true, customClassLoader);
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

class CustomClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomPath(name);
            if (result == null) {
                throw new FileNotFoundException(name);
            } else {
                // defineClass方法将字节码转化为类
                return defineClass(name, result, 0, result.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }


    private byte[] getClassFromCustomPath(String name) {
        // 从自定义路径中加载指定类，返回类的字节码文件
        InputStream in = null;
        ByteArrayOutputStream out = null;
        String path = "/Users/ruixin/Desktop/" + name + ".class";
        try {
            in = new FileInputStream(path);
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
