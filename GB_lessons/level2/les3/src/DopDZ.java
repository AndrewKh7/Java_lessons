import java.util.Scanner;
import java.util.regex.*;

public class DopDZ {

    public static void main(String[] agrs){
        Scanner scan = new Scanner(System.in);

//        String str = scan.nextLine();
//        System.out.println(validTest(str));
        System.out.println(validTest("Pas34"));
        System.out.println(validTest("Paokokoksssword"));
        System.out.println(validTest("password12367"));
        System.out.println(validTest("Password23543"));

    }

    public static boolean validTest(String pass){
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$");
        Matcher match = pattern.matcher(pass);
        return match.matches();
    }
}
