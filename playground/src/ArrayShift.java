import java.util.Arrays;

public class ArrayShift {
    public static void main(String[] args) {
        ArrayShift arrayShift = new ArrayShift();
        int arrSize = 15;
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = i;
        }
        arrayShift.rotateArray(arr, 5);
        System.out.println(Arrays.toString(arr));

    }

    private void rotateArray(int[] dataArray, int shiftIn) {
        int shift = 0;
        if (dataArray.length <= 1 || shiftIn == 0) return;
        if (Math.abs(shiftIn) > dataArray.length) {
            shiftIn = shiftIn % dataArray.length;
        }
        shift = shiftIn >= 0 ? shiftIn : shiftIn + dataArray.length;
        if (shift == 0) return;

//        if (dataArray.length == Math.abs(shift)) return;
        int currentElementIndex = 0;
        int startIndex = 0;
        int nextElementIndex = shift  ;
        int buffer_1 = dataArray[currentElementIndex];
        int buffer_2 = dataArray[nextElementIndex];

        for (int i = 0; i < dataArray.length; i++) {

            dataArray[nextElementIndex] = buffer_1;
            if (nextElementIndex == startIndex) {
                startIndex++;
                nextElementIndex++;
                buffer_2 = dataArray[nextElementIndex];
            }
            buffer_1 = buffer_2;
            nextElementIndex += shift;

            if (nextElementIndex >= dataArray.length) {
                nextElementIndex -= dataArray.length;
            } else if (nextElementIndex < 0) {
                nextElementIndex = nextElementIndex - dataArray.length;
            }

            buffer_2 = dataArray[nextElementIndex];
        }
    }
}
