package clone;

public class CloneClass {

    public static void main(String... args) throws CloneNotSupportedException {
        A a = new A();
        A aa = a.clone();
     }
}

class A implements Cloneable{
    Integer a = 10;

    @Override
    public A clone() throws CloneNotSupportedException {
        return (A) super.clone();
    }
}
