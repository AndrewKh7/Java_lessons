package overloading;

public class Classes {
    public static void main(String... args){
        short i = 4;
        A a = new B();
        a.foo( i );
//        a.bar();
        System.out.println(a.name);
    }
}


class A {

    public String name = "A";

    public A(){}

    public A(String name){
        this.name = name;
    }

    public void foo( long num){
        System.out.println("num in A");
    }

    private void bar(){
        System.out.println(this.name);
    }

    public String getName() {
        return name;
    }
}

class B extends A{
    private String name = "B";

    public B(){}

    public B(String name){
        this.name = name;
    }

     void  foo( int num){
        System.out.println("num in B");
    }

    public void bar(){
        System.out.println(getName());
    }

    @Override
    public String getName() {
        return name;
    }
}
