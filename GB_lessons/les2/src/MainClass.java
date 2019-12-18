import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        int[] test_arr_task1 = {1,1,0,0,1,0,0,1,0,1};
        invertArr(test_arr_task1);
        System.out.println(Arrays.toString(test_arr_task1));
        System.out.println(Arrays.toString(arrMultipleOf3(8)));
        int[] test_arr_task3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        arrValueLess6MulBy2(test_arr_task3);
        System.out.println(Arrays.toString(test_arr_task3));
        printMat(createOnceMat(5));
        System.out.println(findMax(test_arr_task3));
        System.out.println(findMin(test_arr_task3));
        int[] test_arr_task6_1 = {1,1,1,2,1};
        int[] test_arr_task6_2 = {1,2,8};
        System.out.println("test1: " + CheckBalance(test_arr_task6_1) + " ;test2: " + CheckBalance(test_arr_task6_2));
        int[] test_arr_task7 = {1,2,3,4,5,6,7};
//        shiftArr(test_arr_task7, 3);
//        System.out.println(Arrays.toString(test_arr_task7));
        shiftArr(test_arr_task7, -4);
        System.out.println(Arrays.toString(test_arr_task7));
        shiftArr(test_arr_task7, 3);
        System.out.println(Arrays.toString(test_arr_task7));
    }
//  invert value in input arr
    static void invertArr(int[] input_arr){
        int[] output_arr = new int[input_arr.length];
        for (int i = 0; i < input_arr.length; i++) input_arr[i] = input_arr[i] == 0 ? 1 : 0;

    }

//  new array with values ​​multiple of 3
    static int[] arrMultipleOf3(int size){
        int[] out_arr = new int[size];
        for(int i = 0;i < out_arr.length; i++) out_arr[i] = i*3;
        return out_arr;
    }

//  If value in arr lees than 6 multiply it by 2
    static void arrValueLess6MulBy2(int[] input_arr){
        int[] out_arr = new int[input_arr.length];
        for (int i = 0; i < input_arr.length; i++) {
            if (input_arr[i] < 6)
                input_arr[i] = input_arr[i]*2;
        }
    }

//    Print Matrix n by n filled 1 diagonally
    static int[][] createOnceMat(int n){
        int[][] out_arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j){
                    out_arr[i][j] = 1;
                    out_arr[i][n-j-1 ] = 1;
                }
            }
        }
        return out_arr;
    }

    static void printMat(int[][] input_arr){
        for (int i = 0; i < input_arr.length; i++) {
            for (int j = 0; j < input_arr[i].length; j++) {
                System.out.print(input_arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int findMax(int[] arr){
        int res = arr[0];
        for (int value : arr) res = value > res ? res : value;
        return res;
    }

    static int findMin(int[] arr){
        int res = arr[0];
        for (int value : arr) res = value < res ? res : value;
        return res;
    }

    static boolean CheckBalance(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int sum = 0;

        while(left != right){
            if(sum < 0)
                sum += arr[left++];
            else
                sum -= arr[right--];
        }

        if(arr.length % 2 != 0)
            if  (sum < 0 )
                sum += arr[left];
            else
                sum -= arr[right];

            return sum == 0;
    }

    static void shiftArr(int[] arr, int n){
        int temp = arr[0];
        int cnt = n;
        int first_id = 0;
        for (int i = 0; i < arr.length; i++) {
                if(cnt >= arr.length) cnt -= arr.length;
                if(cnt < 0 ) cnt += arr.length;
                arr[cnt] = arr[cnt]+temp-(temp = arr[cnt]); //swap
            if (cnt == first_id) {
                first_id += 1;
                temp = arr[first_id];
                cnt += n + 1;
            }else{
                cnt += n;
            }
        }
    }

}
