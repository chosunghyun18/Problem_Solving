package testprac;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.Test;


public class GrammarSkillTestMay {
    @Test
    void new_method_test() {

        // ArrayList
        System.out.println("Hello World");
        String[] re = {"1", "1", "0", "1", "1"};
        List<String> arr = new ArrayList<>(Arrays.stream(re).collect(Collectors.toList()));
        System.out.println(arr);
        arr.set(2, "1");
        arr.remove(3);
        // Show Matches
        System.out.println(arr);
        String ex = "10";
        System.out.println(ex.charAt(1));
        System.out.println(ex.matches("[0-10]"));


    }
}