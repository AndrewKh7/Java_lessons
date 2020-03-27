public class MainTask {
    public static void main(String[] arg){
       String[][] mass1 ={
               {"1", "2", "3", "5"},
               {"1", "2", "3", "5"},
       };
        String[][] mass2 ={
                {"1", "2", "3", "5"},
                {"1", "2", "3", "5"},
                {"1", "2", "3", "5"},
                {"1", "2", "3", "5"},
        };
        String[][] mass3 ={
                {"1", "2"},
                {"1", "2"},
                {"1", "2"},
                {"1", "2"},
        };
        String[][] mass4 ={
                {"1", "2", "3", "5"},
                {"1", "2", "3", "5"},
                {"1", "Azaza", "3", "5"},
                {"1", "2", "3", "5"},

        };

        trySum(mass1);
        trySum(mass2);
        trySum(mass3);
        trySum(mass4);
    }

    public static void trySum(String[][] el){
        try{
            System.out.println(sumElement(el));
        }catch (MyArraySizeException e){
            e.printStackTrace();
        }catch (MyArrayDataException e){
            e.printStackTrace();
        }
    }
    public static int sumElement(String[][] mass) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if(mass.length == 4) {
            for (String[] m : mass){
                if (m.length != 4)
                    throw new MyArraySizeException("Маасив должен быть 4 на 4");
            }
        }
        else
            throw new MyArraySizeException("Маасив должен быть 4 на 4");

        for(int i = 0; i < 4; ++i)
            for(int j = 0; j < 4; ++j)
                try{
                    sum += Integer.parseInt(mass[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Неверный формат данных в массиве:",i,j, mass[i][j] );
                }
        return sum;
    }
}

class MyArraySizeException extends Exception{
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception{
    public MyArrayDataException(String msg, int x, int y, String val){
        super(msg + "array[" + x + "][" + y + "] = " + val);
    }
}
