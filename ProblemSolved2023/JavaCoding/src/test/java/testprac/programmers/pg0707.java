package testprac.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class pg0707 {
    @Test
    void sol(){
//     String given =  "dxccxbbbxcxabaaxaaba" ;
        String given = "a";
      solution(given);
    }
    public List<String> solution(String myString) {
        //    //13:48 ~ 13:50
        return Arrays.stream(myString.split("x"))
            .filter(str -> !str.isEmpty())
            .sorted().collect(Collectors.toList()) ;
    }

}
