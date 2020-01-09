import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class MainClass {
    static int field_size_x = 3;
    static int field_size_y = 3;
    static int quantity =3;
    static char[][] field;


    static char USER_DOT = 'X';
    static char AI_DOT = 'O';

    static int last_user_point[] = new int[2]; //[0] - 'X' ; ] [1] - 'O'
    static int last_ai_point[] = new int[2];
    static int[] ai_block_point = new int[2];
    static int[] ai_win_point = new int[2];

    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        field = initField();
        printField();
        int i = 0;
        int check_win = 0;
        while( i < field_size_y*field_size_y) {
            if ( i%2 == 0){
                nextUserTurn();
                check_win = prewinDot(last_user_point[0], last_user_point[1],USER_DOT);
            }else{
                int ai_check_win = prewinDot(last_ai_point[0], last_ai_point[1],AI_DOT);
                if (ai_check_win != 0){
                    if( ai_check_win == 1 && check_win == 1 )
                        nextAITurn();
                    else if (ai_check_win > check_win)
                        setDOT(ai_block_point[0], ai_block_point[1], AI_DOT);
                    else
                        setDOT(ai_win_point[0],ai_win_point[1],AI_DOT);

                }else{
                    check_win = ai_check_win;
                }
            }


            printField();
            if(check_win == 0) {
                if ( i%2 == 0) {
                    System.out.println("User win!");
                }
                else {
                    System.out.println("AI win!");
                }
                break;
            }
            ++i;
        }
        if(i>= field_size_x*field_size_y){
            System.out.println("Draw!");
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

        char[][] temp = new char[field_size_y][field_size_x ];
        for (int i = 0; i < field_size_x ; i++) {
            for (int j = 0; j < field_size_y; j++) {
               temp[i][j] = '.';
            }
        }
        return temp;
    }

    public static void printField(){
        System.out.print("    ");
        for (int i = 0; i < field_size_x; i++) {
            System.out.print((i+1) + "   ");
        }
        System.out.println();
        for (int i = 0; i < field_size_y ; i++) {
            System.out.println("  -" + "----".repeat(field_size_x));
            System.out.print((i+1) + " ");
            for (int j = 0 ; j < field_size_x; j++) {
                System.out.print("| " + field[i][j] + " ");
            }
            System.out.println('|');
        }
        System.out.println("  -" + "----".repeat(field_size_x));
    }

    public static  boolean setDOT(int x, int y, char dot){
        if ( x<0 || x>=field_size_x || y<0 || y>=field_size_y)
            return false;

        if (field[y][x] != '.')
            return false;

        field[y][x] = dot;
        if (dot == 'X') {
            last_user_point[0] = x;
            last_user_point[1] = y;
        }else{
            last_ai_point[0] = x;
            last_ai_point[1] = y;
        }
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
        if(field[y][x] != dot) return 1;
        int ret_val = 0;
        int up = 0;
        int down = 0;
        int[] step_and_point = new int[3]; // {how many step, point} ????
        int dir;
        int[] arr = null;
        int steps_and_point = 0;
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
                if ( point >= 0){
                     ret_val =  stepAndPoint(point, arr) > 1 ? 3 : 2; //user or ai can win
                     break;
                } else if ( point == -1){
                    ret_val = 1; // nothing
                    break;
                } else if (point == -2){
                    ret_val = 0; // user or ai win
                }

            }
        int add_val = 0;
        if (arr != null && point >= 0) {
            for (int i = 0; i <= point; i++)
                add_val += (arr[i] < 0) ? -arr[i] : arr[i];
            if (steps_and_point == 0 || steps_and_point == 2)
                add_val += arr[point] - 1;

            if (dot == 'X')
                switch (dir) {
                    case 0:
                        ai_block_point[0] = x - up + add_val;
                        ai_block_point[1] = y;
                        break;
                    case 1:
                        ai_block_point[1] = y - up + add_val;
                        ai_block_point[0] = x - up + add_val;
                        break;
                    case 2:
                        ai_block_point[0] = x;
                        ai_block_point[1] = y - up + add_val;
                        break;
                    case 3:
                        ai_block_point[0] = x + up - add_val;
                        ai_block_point[1] = y - up + add_val;
                        break;
                    default:
                        break;
                }
            else
                switch (dir) {
                    case 0:
                        ai_win_point[0] = x - up + add_val;
                        ai_win_point[1] = y;
                        break;
                    case 1:
                        ai_win_point[1] = y - up + add_val;
                        ai_win_point[0] = x - up + add_val;
                        break;
                    case 2:
                        ai_win_point[0] = x;
                        ai_win_point[1] = y - up + add_val;
                        break;
                    case 3:
                        ai_win_point[0] = x + up - add_val;
                        ai_win_point[1] = y - up + add_val;
                        break;
                    default:
                        break;
                }
        }
        return ret_val;
    }

    public static int[] checkWinLine(int[] line) {
        int[] res = {0, -1};

        if(line.length == 1 || line[1] == 0) {
            if (line[0] >= quantity)
                res[0] = 0;
                res[1] = -2;
        } else {
            for (int i = 0; i < line.length && line[i] != 0; ++i) {
                if (line[i] >= quantity) {

                    res[1] = -2;
                    break;
                }
                if (line[i] == quantity - 1) {
                    if (i == line.length - 1 || line[i + 1] == 0) {
                        res = i - 1;
                    }else{
                        res = i + 1;
                    }
                }
                if (line[i] == -1) {
                    if (i == 0) {
                        if (line[i + 1] == quantity - 1) {
                            res = i;
                            break;
                        }
                    } else if (i == line.length - 1 || line[i + 1] == 0) {
                        if (line[i - 1] >= quantity - 1) {
                            res = i;
                            break;
                        }
                    } else if (line[i - 1] + line[i + 1] >= quantity - 1) {
                        res = i;
                        break;
                    }
                }
                if (line[i] == quantity - 2 && i != 0 && i != line.length - 1) {
                    if (line[i - 1] + line[i + 1] <= -3) {
                        res = i - 1;
                        break;
                    }
                }

            }
        }

        return res;
    }



}
