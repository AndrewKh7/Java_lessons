package overloading;

public class Primitive {

    public static void main(String... args){
        int a = 1;
        byte b = 2;

        method(a,b);
    }

//    public static void method(int a, byte b){
//        System.out.println("int, byte");
//    }

//    public static void method(int a, int b){
//        System.out.println("int, int");
//    }

//    public static <T> void  method(int a, T b){
//        System.out.println("int, T");
//    }

    public static void method(int a, Object b){
        System.out.println("int, Object");
    }

    public static void method(int a, Byte b){
        System.out.println("int, Byte");
    }
}

