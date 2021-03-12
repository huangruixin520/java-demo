package demo_v1.temp.jvm;


public class ClassLoaderOrderDemo {

    private static ClassLoaderOrderDemo singleton = new ClassLoaderOrderDemo();
    public static int counter;
    public static int counter2 = 0;
    public ClassLoaderOrderDemo() {
        counter++;
        counter2++;
    }
    public static ClassLoaderOrderDemo getInstance(){
        return singleton;
    }
    public static class TestSingleton{
        public static void main(String[] args) {
            ClassLoaderOrderDemo s = ClassLoaderOrderDemo.getInstance();
            System.out.println(ClassLoaderOrderDemo.counter);
            System.out.println(ClassLoaderOrderDemo.counter2);
        }
    }
}
