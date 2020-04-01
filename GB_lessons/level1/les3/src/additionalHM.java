import java.util.Arrays;

public class additionalHM {
    public static void main(String[] args) {
        int[][] mat = new int[5][5];
        fillingMat(mat);
        for (int[] st : mat){
            for (int c: st )
                System.out.print(c+" ");
            System.out.println();
        }
    }

    static void fillingMat(int[][] arr){
        int J = arr.length;
        int I = arr[0].length;
        int S = I*J;
        for (int j = 0; j < J; j++) {
            for (int i = 0; i < I; i++) {
                int l = min(i, j, I-i-1, J-j-1); //На сколько далеко от края матрицы находитяс элемент
                if ( (i==(I-l-1)) || (j==l)) // Выобр формулы изходя из того является ли элемент в верхней-правой половине, или нижней-левой
                    arr[j][i] = i+j-2*l+S-I*(I-2*l)*(J-2*l); // формуля для верхней левой половины для каждого прямоугольника (общий принцип i+j)
                else
                    arr[j][i] = S-(I-2*(l+1))*(J-2*(l+1)) -i -j + 2*l; //формула для нижней-левой половины для каждого прямоугольника по принципц (Максимальное значение в квадрате - i - j)
            }
        }
    }

    static int min(int a, int b, int c, int d){
        int min = a;
         if (d < min)
             min = a;
         else if (b < min)
             min = b;
         else if (c < min)
             min = c;
        return min;
    }
}
