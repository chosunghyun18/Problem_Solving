package testprac.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class pg0707 {
    @Test
    void sol1(){
//     String given =  "dxccxbbbxcxabaaxaaba" ;
        String given = "a";
      solution1(given);
    }
    public List<String> solution1(String myString) {
        //    //13:48 ~ 13:50
        return Arrays.stream(myString.split("x"))
            .filter(str -> !str.isEmpty())
            .sorted().collect(Collectors.toList()) ;
    }
    @Test
    void sol2(){
        int given = 1081 ;
        solution(given);
    }
    public int solution(int chicken) {
        //14:24 ~
        if(chicken < 10) return 0 ;
        int service = 0 ;
        int coupon = chicken ;
        while(chicken > 9 ){
            int left = 0 ;
            int serviceTmp = 0 ;
            serviceTmp += chicken / 10 ;
            service += serviceTmp ;
            left = chicken % 10;
            chicken = serviceTmp + left;
        }

        return service;
    }




}
