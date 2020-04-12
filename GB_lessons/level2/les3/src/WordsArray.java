import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordsArray {
    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<>(20);
        for (int i = 0; i < 20 ; i++) {
            if(i%3 == 0) {
                words.add("word" + (i / 3));
            } else {
                if (i > 10) {
                    words.add("word" + (i-10));
                }else{
                    words.add("word"+i);
                }
            }
        }
        Set<String> wordsSet = (Set<String>)(new HashSet<>(words));
        HashMap<String,Integer> wordsCount = new HashMap<>(20);
        for(String word: words){
           Integer num = wordsCount.get(word);
            wordsCount.put(word, num==null ? 1 : num+1);
        }

        System.out.println(words);
        System.out.println(wordsSet);
        System.out.println(wordsCount);

    }
}
