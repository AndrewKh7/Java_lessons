package streamTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SreamTest {
    public static void main(String... args){
        List<Integer> list = List.of(1,2,3,4,5,3,1,3,4,2,4,5,7,8,6,3,34,5,35);

        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println(collect);
    }
}
