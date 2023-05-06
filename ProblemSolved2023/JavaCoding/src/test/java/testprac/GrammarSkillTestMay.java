package testprac;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.Test;


public class GrammarSkillTestMay {
    @Test
    void new_method_test() {

        // ArrayList
        String[] re = {"1", "1", "0", "1", "1"};
        List<String> arr = new ArrayList<>(Arrays.stream(re).collect(Collectors.toList()));

        System.out.println(arr); //   [1, 1, 0, 1, 1]

        arr.set(2, "1");
        arr.remove(3);

        System.out.println(arr); // [1, 1, 1, 1]
        double[] darr = {1.0,2.0,3.0};
        List<Double> darrList = new ArrayList<>(Arrays.stream(darr).mapToObj(Double::valueOf).collect(Collectors.toList()));
        // Double::new 보다 성능이 좋음 cache, memory 차이+ jdk 회서 버전 체크해야함
        System.out.println(darrList);
    }
}