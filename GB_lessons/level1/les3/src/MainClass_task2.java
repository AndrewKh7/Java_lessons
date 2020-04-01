import java.util.Random;
import java.util.Scanner;

public class MainClass_task2 {
    public static void main(String[] args) {
        String[] words = {
                "apple", "orange", "lemon",
                "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon",
                "leak", "kiwi", "mango",
                "mushroom", "nut", "olive",
                "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin",
                "potato"
        };
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        String hidden_word = words[ran.nextInt(words.length)];
        System.out.println("Я загадал слово!");
        do{
            String word = sc.nextLine().toLowerCase();
            int i = 0;
            String temp_word = "";
            while(i < word.length() && i < hidden_word.length()){
                temp_word += (word.charAt(i) == hidden_word.charAt(i)) ? word.charAt(i) : '#';
                i++;
            }
            if (temp_word.equals(hidden_word)) {
                System.out.println("Угадал!");
                break;
            }else{
                System.out.println(temp_word + "#".repeat(15-temp_word.length()));
            }
        }while(true);
    }

}
