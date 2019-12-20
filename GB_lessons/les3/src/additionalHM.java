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
            for (int i = 0; i < arr[0].length; i++) {
                int l = min(i, j, I-i-1, J-j-1);
                if ( (i==(I-l-1)) || (j==l))
                    arr[j][i] = i+j-2*l+S-I*(I-2*l)*(J-2*l);
                else
                    arr[j][i] = S-(I-2*(l+1))*(J-2*(l+1)) -i -j + 2*l;
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