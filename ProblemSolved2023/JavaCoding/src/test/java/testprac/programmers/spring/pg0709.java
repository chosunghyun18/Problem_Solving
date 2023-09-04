package testprac.programmers.spring;

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
        solution1(n,works);
    }
    public long solution1(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());;
        for (int work : works) {
            pq.offer(work);
        }

        for(int i =0 ; i< n ;i++){
            int item = pq.poll();
            if(item <= 0 ) return  0;
            pq.offer(item -1 );
        }

        long answr = 0 ;
        while(!pq.isEmpty()){
            answr += Math.pow(pq.poll(),2);
        }
        return  answr;
    }
    @Test
    void stringSubTes() {
        String given = "012345" ;

        String[] givearr = given.split("");
        int index = 1 ;
        String tmp = "";
        for(String item :givearr ){
            tmp+=item;
        }
        tmp = tmp.substring(0,index) + tmp.substring(index+1);
          //  this is get String in range
        System.out.println(tmp);

    }
    @Test
    void sol5(){
        //size = 3~ 10^6
        int[] money ={1,2,3,1}; // 4 개의 집이 원형구조 , 0~1000 , 정수
    }
    public int solution(int[] money) {
        // 인접한 두 집을 털지 앟고 최대 돈을 훔치기

        int answer = 0;

        return answer;
    }

}
