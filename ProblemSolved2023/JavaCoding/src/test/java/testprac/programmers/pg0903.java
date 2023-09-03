package testprac.programmers;

import java.util.*;
import java.util.stream.*;


public class pg0903 {
    int target = 0;
    int[] scoville ;
    public int solution(int[] scoville, int K) {
        target = K;
        this.scoville = scoville;
        int answer = 0;
        Arrays.sort(this.scoville);
        boolean done = false ;
        while(!done) {
            if(!isDone()){
                answer++;
                int value = scoville[0]+(scoville[1]*2);
                int[] tmp = Arrays.copyOfRange(scoville,1,scoville.length);
                tmp[0] = value;
                System.out.println(Arrays.toString(tmp));
                this.scoville = tmp.clone();
                Arrays.sort(this.scoville);
            }else{
                done = true;
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
