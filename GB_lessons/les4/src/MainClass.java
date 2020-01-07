import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class MainClass {
    static int field_size_x = 3;
    static int field_size_y = 3;
    static int quantity =3;
    static char[][] field;
    static int[] win_dot;

    static char USER_DOT = 'X';
    static char AI_DOT = 'O';

    static int last_point_y;
    static int last_point_x;

    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        field = initField();
        printField();
        int check_win;
        int i = 0;
        int temp = 0;
        while( i < field_size_y*field_size_y) {
            nextUserTurn();
            temp = prewinDot(last_point_x, last_point_y,USER_DOT);
//            if (checkWin(last_point_x, last_point_y, USER_DOT)){
            if(temp == 1) {
                printField();
                System.out.println("User win!");
                break;
            }
            ++i;
            if(i>= field_size_x*field_size_y){
                printField();
                System.out.println("Draw!");
                break;
            }
            if (temp == 2){
                setDOT(win_dot[0],win_dot[1],AI_DOT);
                System.out.println(win_dot[0] + " " + win_dot[1]);
            }
            else
                nextAITurn();
            printField();
            temp = prewinDot(last_point_x, last_point_y,AI_DOT);
//            if(checkWin(last_point_x, last_point_y,AI_DOT)){
            if (temp == 1){
                System.out.println("AI win!");
                break;
            }


            if (i == field_size_y*field_size_y) {
                printField();
                System.out.println("Draw!");
                break;
            }
            ++i;
        }
    }

    public static char[][] initField(){
        System.out.print("Введите размер поля x:");
        field_size_x = scanner.nextInt();
        System.out.print("Введите размер поля y:");
        field_size_y = scanner.nextInt();
        System.out.print("Введите количество подряд идущих знаков для победы: ");
        quantity = scanner.nextInt();
        if (field_size_y < 3) field_size_y = 3;
        if (field_size_x < 3) field_size_x = 3;
        if (quantity > field_size_y || quantity > field_size_x || quantity < 3) {
            quantity = field_size_y < field_size_x ? field_size_y : field_size_x;
        }
        System.out.println(quantity);
        char[][] temp = new char[field_size_y][field_size_x ];
        for (int i = 0; i < field_size_x ; i++) {
            for (int j = 0; j < field_size_y; j++) {
               temp[i][j] = '.';
            }
        }
        return temp;
    }

    public static void printField(){
        for (int i = 0; i < field_size_y ; i++) {
            System.out.println("-" + "----".repeat(field_size_x));
            for (int j = 0 ; j < field_size_x; j++) {
                System.out.print("| " + field[i][j] + " ");
            }
            System.out.println('|');
        }
        System.out.println("-" + "----".repeat(field_size_x));
    }

    public static  boolean setDOT(int x, int y, char dot){
        if ( x<0 || x>=field_size_x || y<0 || y>=field_size_y)
            return false;

        if (field[y][x] != '.')
            return false;

        field[y][x] = dot;
        last_point_x = x;
        last_point_y = y;
        return true;
    }

    public static void nextUserTurn(){
        int x;
        int y;
        boolean succuss = false;
        System.out.println("Ваш ход! Введите координаты: ");
        do{
            System.out.print("x: ");
            x = scanner.nextInt() - 1;
            System.out.print("y: ");
            y = scanner.nextInt() - 1;
            succuss = setDOT(x, y, USER_DOT);
            if (!succuss)
                System.out.println(" Указанное место занято или находится за передами поля");
        }while (!succuss);
    }

    public static void nextAITurn(){
        int x;
        int y;
        do{
            x = rand.nextInt(field_size_x);
            y = rand.nextInt(field_size_y);
        }while (!setDOT(x,y,AI_DOT));
    }

    public static boolean checkWin(int x, int y, char dot){
        for (int i = 0; i < 4; i++) {
            if( countingDot(x, y, i, dot) + countingDot(x, y, i+4 , dot) - 1 == quantity )
                return true;
        }
        return false;
    }

    public static int countingDot(int x, int y, int dir, char dot){
        int cnt = 0;
        while ( x >= 0 && y >= 0 && x < field_size_x && y <  field_size_y && field[y][x] == dot) {
            cnt += 1;
            switch (dir) {
                case 0:
                    --x;
                    break;
                case 1:
                    --x;
                    --y;
                    break;
                case 2:
                    --y;
                    break;
                case 3:
                    --y;
                    ++x;
                    break;
                case 4:
                    ++x;
                    break;
                case 5:
                    ++x;
                    ++y;
                    break;
                case 6:
                    ++y;
                    break;
                case 7:
                    ++y;
                    --x;
                    break;
                default:
                    return -1;
            }
        }
        return cnt;
    }

    public static int prewinDot(int x, int y, char dot) {
        int ret_val = 0;
        int up = 0;
        int down = 0;
        int temp_x = 0;
        int temp_y = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
//            if (ret_val != 0) break;
            up = countingDot(x, y, i, dot);
            down = countingDot(x, y, i+4 , dot);
            if( (up + down - 1 >= quantity - 2) && (up + down - 1 > max) ) {
                max = up + down - 1;
                switch (i) {
                    case 0:
                        if (x >= up)
                            if (rememberWinPoint(x - up, y))
                                ret_val = 2;
                        if (x + down < field_size_x)
                            if (rememberWinPoint(x + down, y))
                                ret_val = 2;
                        break;
                    case 1:
                        if (x >= up && y >= up)
                            if (rememberWinPoint(x - up, y - up))
                                ret_val = 2;
                        if (x + down < field_size_x && y + down < field_size_y)
                            if (rememberWinPoint(x + down, y + down))
                                ret_val = 2;
                        break;
                    case 2:
                        if (y >= up)
                            if (rememberWinPoint(x, y - up))
                                ret_val = 2;
                        if (y + down < field_size_y)
                            if (rememberWinPoint(x, y + down))
                                if (rememberWinPoint(x, y + down))
                                    ret_val = 2;
                        break;
                    case 3:
                        if (x + up < field_size_x && y >= up)
                            if (rememberWinPoint(x + up, y - up))
                                ret_val = 2;
                        if (x > down && y + down < field_size_y)
                            if (rememberWinPoint(x - down, y + down))
                                ret_val = 2;
                        break;
                    default:
                        ret_val = 0;
                        break;
                }
            }
            if ( up + down -1 >= quantity)
                ret_val = 1;
        }
        return ret_val;
    }

    public static boolean rememberWinPoint(int x, int y) {
        if (field[y][x] == '.') {
            win_dot = new int[2];
            win_dot[0] = x;
            win_dot[1] = y;
            return true;
        }else{
            return false;
        }

    }
}
