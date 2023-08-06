package testprac.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class pg0806 {
    @Test
    public void sol_see_saw_test() {
        int [] w = {100, 180,100, 360, 100, 270,180};
        solution(w);
    }

    public int gcd(int a , int b) {
        return b == 0 ? a : gcd(b,a%b) ;
    }

    public long solution(int[] weights) {
        int n = weights.length;
        Arrays.sort(weights);                         // 100 ,180 , 270 , 360
        long answer = 0;
        List<Integer> arr = new ArrayList<>();
        int tmp = weights[0];
        arr.add(tmp);

        int lastUpdate = 0 ;

        for(int i = 1 ; i < n ; i++ ) {
            if(tmp == weights[i]) {
                if(lastUpdate != weights[i]){
                    answer += 1;
                    lastUpdate = weights[i];
                }
            }
            else{
                arr.add(weights[i]);
                tmp = weights[i];
            }
        }

        for(int i = 0  ; i < arr.size() - 1; i++) {
            for(int j = i +1 ; j < arr.size();j++) {
                int a = arr.get(i);
                int b = arr.get(j);
                int lcm = (a * b) / gcd(a, b);

                int qa = lcm / a;
                int qb = lcm / b;

                if( 1 <= qa && qa <= 4 && 1 <= qb && qb <= 4) {
                    answer++;
                }
            }

        }
        System.out.println(answer);
        return answer;
    }


}
