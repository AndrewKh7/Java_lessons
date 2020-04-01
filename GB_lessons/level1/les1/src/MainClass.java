

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Hellow world");

        System.out.println(calculate(2,1,4,2));
        System.out.println(SumMoreThan10AndLessThan20(5,8));
        isNegativePrint(-5);
        System.out.println(isNegative(-19));
        hellowName("Andrey");
        isLeap(2020);

    }

    // Just created variable all of data type.
    public static void allOfDataType(){
        byte  bt = 120;
        short sh_int = 255;
        int in = 9999;
        long long_int = 99999999;
        double db = 0.5;
        float flt = 2.2f;
        char ch = 'A';
        String str = "Hellow world!";
        boolean flag = true;
    }

    // calculate by the formula a * (b + (c/d)).
    public static double calculate(int a, int b, int c, int d){
        return  a * (b + (c / d));
    }

    //Check if amount is from 10 to 20.
    public static boolean SumMoreThan10AndLessThan20(int a,int b){
        int  sum = a + b;
        return sum > 10 && sum <= 20;
    }

    //prints a number is negative or positive.
    public static void isNegativePrint(int val){
        if (val < 0 )
            System.out.println(val + " Меньше нуля");
        else
            System.out.println(val + " Больше нуля");
    }

    //return true if val is negative.
    public static boolean isNegative(int val){
        return val < 0;
    }

    //print "Hellow, <name>!".
    public static void hellowName(String name){
        System.out.println("Привет, " + name + "!");
    }

    //Check if a year is leap and print it.
    public static void isLeap(int year){
        if (year % 400 == 0)
            System.out.println(year + " год високосный");
        else if (year % 100 == 0)
            System.out.println(year + " год не високосный");
        else if (year % 4 == 0)
            System.out.println(year + " год високосный");
        else
            System.out.println(year + " год не високосный");
    }
}
