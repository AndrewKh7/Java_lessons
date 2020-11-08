import java.util.*;
import java.util.Arrays;

class minusCollections {

    public static void main(String[] args){
            Set<Integer> set1 = new HashSet<>(Arrays.asList(new Integer[] {1,2,3}));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(new Integer[] {1,2,0}));
        System.out.println(symmetricDifference(set1,set2));
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> answer = new HashSet<>(set1);
        Set<T> help = new HashSet<>(set2);
        answer.removeIf(help::remove);
        answer.addAll(help);
        return answer;
    }

}



