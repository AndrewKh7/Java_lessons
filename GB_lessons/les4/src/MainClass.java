import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class MainClass {
    static int field_size_x = 3;
    static int field_size_y = 3;
    static int quantity =3;
    static char[][] field;
    static int[] win_dot = new int[2]; //[0] - x; [1] - y;

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
        //TODO: refactoring cycle (if i%2 then user turn, else AI turn )
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
        System.out.print("Введите размер поля x: ");
        field_size_x = scanner.nextInt();
        System.out.print("Введите размер поля y: ");
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
        int up;
        int down;
        for (int dir = 0; dir < 4; dir++) {
            if( countingDot(x, y, dir, dot) + countingDot(x, y, dir+4 , dot) - 1 == quantity )
                return true;
        }
        return false;
    }

    public static int countingDot(int x, int y, int dir, char dot){
        int cnt = 0;
        while ( x >= 0 && y >= 0 && x < field_size_x && y <  field_size_y && (field[y][x] == dot || field[y][x] == '.') ) {
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

    public static int[] shortViewOfDotArray(int x, int y, int dir, int num, char dot){
        char prev_dot = field[y][x];
        int cnt = 0;
        int index = 0;
        int[] short_arr = new int[num];
        for (int i = 0; i < num; i++) {
            if ( field[y][x] == prev_dot )
                ++cnt;
            else{
                if (prev_dot == '.')
                    short_arr[index] = -cnt;
                else
                    short_arr[index] = cnt;
                cnt = 1;
                ++index;
                prev_dot = field[y][x];
            }
            switch (dir) {
                case 0:
                    ++x;
                    break;
                case 1:
                    ++x;
                    ++y;
                    break;
                case 2:
                    ++y;
                    break;
                case 3:
                    ++y;
                    --x;
                    break;
                default:
                    break;
            }
        }
        if (prev_dot == '.')
            short_arr[index] = -cnt;
        else
            short_arr[index] = cnt;


        return short_arr;
    }

    public static int prewinDot(int x, int y, char dot) {
        int ret_val = 0;
        int up = 0;
        int down = 0;
        int point = -1;
        int max = 0;
        int dir;
        int[] arr = null;
        for ( dir = 0 ; dir < 4; dir++) {
            up = countingDot(x, y, dir, dot);
            down = countingDot(x, y, dir + 4 , dot);

                switch (dir) {
                    case 0:
                        arr = shortViewOfDotArray(x - up + 1, y, dir, up + down - 1, dot);
                        break;
                    case 1:
                        arr = shortViewOfDotArray(x - up + 1, y - up + 1, dir, up + down - 1, dot);
                        break;
                    case 2:
                        arr = shortViewOfDotArray(x, y - up + 1, dir, up + down - 1, dot);
                        break;
                    case 3:
                        arr = shortViewOfDotArray(x + up - 1, y - up + 1, dir, up + down - 1, dot);
                        break;
                    default:
                        arr = new int[1];
                        break;
                }
                point = checkWinLine(arr);
                if (point >= 0){
                    ret_val = 2;
                    break;
                }
                if (point == -2){
                    ret_val = 0;
                }
            }
        int add_val = 0;
        if (arr != null && point != -1) {
            for (int i = 0; i <= point; i++)
                add_val += (arr[i] < 0) ? -arr[i] : arr[i];

//            System.out.println("dir: " + dir);
            switch (dir) {
                case 0:
                    win_dot[0] = x - up + add_val ;
                    win_dot[1] = y;
                    break;
                case 1:
                    win_dot[1] = y - up + add_val;
                    win_dot[0] = x - up + add_val;
                    break;
                case 2:
                    win_dot[0] = x;
                    win_dot[1] = y - up + add_val;
                    break;
                case 3:
                    win_dot[0] = x + up - add_val;
                    win_dot[1] = y - up + add_val;
                    break;
                default:
                    break;
            }
        }
        return ret_val;
    }

    public static int checkWinLine(int[] line) {
        int res = -1;
//        System.out.println("line: " + Arrays.toString(line));
        for (int i = 0; i < line.length && line[i] != 0;  ++i) {
            if (line[i] >= quantity){
                res = -2;
                break;
            }
            if (line[i] == -1 ){
                if (i == 0){
                    if (line[i+1] == quantity - 1) {
                        res = i;
                        break;
                    }
                }
                 else if (i == line.length - 1 || line[i+1] == 0){
                    if (line[i-1] >= quantity-1) {
                        res = i;
                        break;
                    }
                } else if (line[i-1] + line[i+1] >= quantity ){
                    res = i;
                    break;
                }
            }
            if (line[i] == quantity - 2 && i != 0 && i != line.length - 1){
                if ( line[i-1] + line[i+1] <= -3){
                    res = i - 1;
                    break;
                }
            }

        }
//        System.out.println("res: " + res);
        return res;
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
