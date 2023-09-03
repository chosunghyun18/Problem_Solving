package testprac.programmers;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.Test;


public class pg0903 {
    @Test
    public void test(){
        //int[] s = {1, 2, 3, 9, 10, 12} ;
        int[] s = {1, 1,1,10} ;
        int k = 9;
        System.out.println(solution(s, k));
    }
    int target = 0;
    int[] scoville ;
    public int solution(int[] scoville, int K) {
        target = K;
        this.scoville = scoville.clone();
        int answer = 0;
        Arrays.sort(this.scoville);
        boolean done = false ;
        while(!done) {
            if(!isDone()){
                answer++;
                if(this.scoville.length <= 1) {
                    if(this.scoville[0] < target) return -1;
                    return answer;
                }
                int value = this.scoville[0]+(this.scoville[1]*2);
                int[] tmp = Arrays.copyOfRange(this.scoville,1,this.scoville.length);
                tmp[0] = value;
                System.out.println(Arrays.toString(tmp));
                this.scoville = tmp.clone();
                Arrays.sort(this.scoville);
            }else{
                return answer;
            }
        }

        return -1;
    }
    public boolean isDone(){
        for(int i = 0 ; i<scoville.length;i++) {
            int check = scoville[i];
            if(check < target) {
                return false;
            }
        }
        return true;
    }

}
