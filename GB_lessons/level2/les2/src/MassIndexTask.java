public class MassIndexTask {
    public static void main(String[] args){

        String[] strArr = {
                "118 2.05",
                "106 1.77",
                "87 1.83",
                "45 1.12",
                "70 1.87",
                "54 1.57",
                "105 1.76",
                "50 1.96",
                "114 1.76",
                "72 2.45",
                "53 2.10",
                "66 2.25",
                "54 1.50",
                "95 1.62",
                "86 1.72",
                "62 1.57",
                "65 2.24",
                "72 1.43",
                "93 2.01",
                "109 3.01",
                "106 2.97",
                "77 1.69",
                "114 2.09",
                "98 1.72",
                "85 2.46",
                "113 1.94",
                "53 1.77",
                "106 2.30"
        };

        for(String s: strArr){
            System.out.println(calculateMassIndex(s));
        }
    }

    public static String calculateMassIndex(String inputStr){
        String[] str = inputStr.split(" ",2);
        float mass = Float.parseFloat(str[0]);
        float height = Float.parseFloat(str[1]);
        float index = mass/(height*height);

        String res;
        if(index < 18.5){
            res = "under";
        }else if( index >= 18.5 && index < 25 ) {
            res = "normal";
        }else if( index >= 25 && index < 30 ) {
            res = "over";
        }else{
            res = "obese";
        }

        return inputStr + " " + res;
    }
}
