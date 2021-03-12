package demo_v1.temp.exam;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-03-28
 */
public class Base {
    int x = 10;

    public Base() {
        System.out.println("base contructor"+this.toString());
        this.printMessage();
        x = 10;
    }
    public void printMessage(){
        System.out.println("Base.x="+x);
    }
}

class Sub extends Base{
    int x = 30;

    public Sub() {
       System.out.println("sub contructor"+this.toString());
       this.printMessage();
       x=40;
    }

    @Override
    public void printMessage(){
        System.out.println("Sub.x="+x);
    }

    public static class TestSub{
        public static void main(String[] args) {
            Base b = new Sub();
            System.out.println(b.x);
        }
    }
}
