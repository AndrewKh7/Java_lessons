public class staticTest {
    public static void main(String[] args) {
        System.out.println("Hellow from main!");
        Foo foo = new Foo();
    }
}

class Foo{
    Foo (){
        System.out.println("Hellow from constructor Foo");
    }

    static {
        System.out.println("Hello from Foo");
    }

}
