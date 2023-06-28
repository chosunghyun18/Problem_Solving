package testprac.programmers;

import java.util.*;

import org.junit.jupiter.api.Test;

public class programmes0627 {
    // x는 -10000000 이상, 10000000 이하인 정수입니다.
    //n은 1000 이하인 자연수입니다.
    @Test
    void codding_test_1 () {
        int x = 10000000 ;
        int n = 1000  ;
        System.out.println(Arrays.toString(sol1(x,n)));
    }
    long[] sol1(int x , int n ){
        long[] arr = new long[n];
        arr[0] = x ;
        if( n == 1) return arr ;

        for(int i = 1 ; i < n ; i++){
            arr[i] = arr[i-1] + x ;
        }
        return arr ;
    }
    @Test
    void sol2(){
        String[] gi = {"Jane", "Kim"} ;
        System.out.println(sol2(gi));
    }
    public String sol2(String[] seoul) {
        String answer = "";
        String find = "Kim";
        int count = 0 ;
        for(String name : seoul){
            if (name.equals(find)){
                return Integer.toString(count);
            }
            else count +=1 ;
        }
        return answer;
    }
}
