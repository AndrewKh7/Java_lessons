import java.util.Random;
import java.util.Scanner;

public class MsinClass_task1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int hidden_num;

        do{
            hidden_num = random.nextInt(10);
            System.out.println("Я загадал число! Угадай его!");
            for (int i = 0; i <= 2; i++) {
                int num = scanner.nextInt();
               if (num > hidden_num)
                   System.out.println("Много!");
               else if (num < hidden_num)
                   System.out.println("Мало!");
               else if (num == hidden_num)
                   System.out.println("Правильно, победа!");
               if  (i == 3 ){
                   System.out.println("Проигрыш!");
                   break;
                }
            }
            System.out.println(" Хотите сыграть еще раз? 1 - повторить; 0 - закончить игру");
        }while(scanner.nextInt() == 1);
        System.out.println("Спасибо за игру!");
        scanner.close();
    }


}
