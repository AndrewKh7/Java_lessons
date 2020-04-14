import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Notebook {
    public static Map<String, HashSet<String>> notebook = new HashMap<>();
    public static void main(String[] args){
        add("Lera","+123");
        add("Lera", "+321");
        add("Lera", "+5621");
        add("Petrov", "+9999324321");
        add("Petrov", "+090909905621");
        add("Gada", "+000321");
        add("Gada", "+111321");
        add("Gada", "+2222321");
        add("Gada", "+333321");

        print(get("Lera"));
        System.out.println("_____________");
        print(get("Petrov"));
        System.out.println("_____________");
        print(get("Gada"));
    }

    static void add(String surname, String number){
        if(!notebook.containsKey(surname))
            notebook.put(surname,new HashSet<>());
        notebook.get(surname).add(number);
    }

    static String[] get(String surname){
        return  notebook.get(surname).toArray( new String[0]);
    }

    static void print(String[] num){
        for (String n: num) {
            System.out.println(n);
        }
    }
}
