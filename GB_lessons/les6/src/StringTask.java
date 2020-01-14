
import java.io.OutputStream;
import java.util.Scanner;
public class StringTask {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println( splitSentenses(str) );
    }

    static String splitSentenses(String str){
        StringBuffer strbuf = new StringBuffer(str);
        int ru_min = 'А';
        int ru_max = 'Я';
        int en_min = 'A';
        int en_max = 'Z';
        int cnt = 0;
        for (int i = 1; i < strbuf.length(); i++) {
            int code = strbuf.codePointAt(i);
            if( (code >= ru_min && code <= ru_max) || (code >= en_min && code <= en_max)) {
                ++cnt;
                strbuf.insert(i++ - 1,".");
            }

        }
        if (strbuf.charAt( strbuf.length()-1) != '.')
            strbuf.append('.');

        return strbuf.toString();
    }
}
