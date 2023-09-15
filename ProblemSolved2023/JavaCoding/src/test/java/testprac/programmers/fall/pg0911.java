package testprac.programmers.fall;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;

public class pg0911 {


    @Test
    public void pockTest() {
        int[] given = {1,2};
        int re = solution(given);
        System.out.println(re);
    }
    public int solution(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        int n  = nums.length;
        int pick = n /2 ;
        System.out.println(n);
        System.out.println();
        for(int item : nums ){
            map.put(item,map.getOrDefault(item,0)+1);
            // map.remove(item);
        }
        System.out.println(map);
        if(map.size() ==1){
            return 1 ;
        }
        if(map.size() > pick){
            return pick ;
        }else{
            return map.size();
        }

    }

}
