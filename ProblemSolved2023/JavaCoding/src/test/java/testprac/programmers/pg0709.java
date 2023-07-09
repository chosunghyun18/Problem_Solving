package testprac.programmers;

import java.util.*;
import org.junit.jupiter.api.Test;

public class pg0709 {
    @Test
    void sol3_1(){
//        solution(2,9);
        //solution(1,9);
        solution3_1(5,12); // 2 , 2, 2 , 3, 3
    }
    public int[] solution3_1(int n, int s) {
        int head = s/ n ;
        int left = s % n;
        if (head == 0) {
            return new int[] {-1};
        }
        int[] answer = new int[n];
//        Arrays.fill(answer,head);
        int index = 0;
        for(int i = 0 ; i <= left ; i++) {
            answer[i] += (1 +head) ;
            index = i;
        }
        for(int i = index ; i <n;i++){
            answer[i] = head;
        }

        Arrays.sort( answer);

        System.out.println(Arrays.toString(answer));
        return answer;
    }
    @Test
    void solw4(){
        int[]  works = {4, 3, 3};
        int n = 4 ;
        solution(n,works);
    }
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());;
        for (int work : works) {
            pq.add(work);
        }
        int index = n ;
        while (index > 0) {
            int item = pq.poll();
            if(item <= 0 ) return  0;
            item-=1;
            pq.add(item);
            index--;
        }
        int answr = 0 ;
        while(!pq.isEmpty()){
            int item = pq.poll();
            answr +=(item)*(item);
        }
        return  answr;
    }


}
