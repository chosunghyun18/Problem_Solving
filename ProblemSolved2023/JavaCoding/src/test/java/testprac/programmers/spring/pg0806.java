package testprac.programmers.spring;

import java.util.*;
import java.util.stream.* ;
import org.junit.jupiter.api.Test;

public class pg0806 {
    @Test
    public void sol_see_saw_test() {
        int [] w = {100, 180, 360, 100, 270};
        solution1(w);
    }

    public int gcd(int a , int b) {
        return b == 0 ? a : gcd(b,a%b) ;
    }

    public long solution1(int[] weights) {
        int n = weights.length;
        Arrays.sort(weights);                         // 100 ,180 , 270 , 360
        long answer = 0;

        int tmp = weights[0];
        int count = 1 ;

        for(int i = 1 ; i < n ; i++ ) {
            if(tmp == weights[i]) {
                count++;
            }
            else{
                tmp = weights[i] ;
                if(count != 1) {
                    if(count == 2){
                        answer++;
                    }else{answer = (long) ((count*(0.5))*(count -1 ));}

                    count =1 ;
                    tmp = weights[i] ;
                }
            }
        }
        List<Integer> arr = Arrays.stream(weights).boxed().collect(Collectors.toList());
        arr = arr.stream().distinct().collect(Collectors.toList());


        for(int i = 0  ; i < arr.size() - 1; i++) {
            int a = arr.get(i);
            for(int j = i +1 ; j < arr.size();j++) {
                int b = arr.get(j);
                if(a*2 == b) answer++;
                if(a*(1.5) == b) answer++;
                if(a*(4) == b*(3)) answer++;
            }

        }
        System.out.println(answer);
        return answer;
    }
    @Test
    void sptlit_string(){
        int[][]  b = {{0,0,0},{0,0,0},{0,0,0}} ;
        solution(b);
    }
    public int solution(int[][] board) {
        int cornerCost = 500  ;
        int oneWayCost = 100 ;

        // 최단 거리를 가지는 모든 경우를 구한다.

        // 모든 경우의 코너회전 횟수와 , 직선 횟수를 구한다.

        int answer = 0;
        return answer;
    }
    @Test
    void integerReplacement(){

    }
    Map<Integer,Integer> integerMap =  new HashMap<>();
    public int integerReplacement(int n) {
        if(n == Integer.MAX_VALUE) return 32;
        if( n == 1) return 0 ;
        if( integerMap.containsKey(n) ) {
            return integerMap.get(n);
        }
        else if( n % 2 == 0 ) {
            integerMap.put(n,integerReplacement(n/2) +1 );
        }
        else{
            integerMap.put(n,Math.min(integerReplacement(n+1), integerReplacement(n-1))+1);
        }
        return integerMap.get(n);
    }
    @Test
    public void duplicated_test(){
        int[] nums = {1,2,3,1} ;
        System.out.println(containsDuplicate(nums));
    }
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int size = Arrays.stream(nums).
                distinct().
                boxed().
                collect(Collectors.toList()).size();
        return size == nums.length;
    }




}


















