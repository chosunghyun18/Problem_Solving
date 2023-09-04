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
        System.out.println(solution1(s, k));
    }
    int target = 0;
    int[] scoville ;
    public int solution1(int[] scoville, int K) {
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
    @Test
    public void sol_test(){
        int[] p = {1,2,7,2,3,8,6,1};
        System.out.println(Arrays.stream(solution(p)));
    }



    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }

            stack.push(i);
        }


        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }

        return answer;
    }

}
