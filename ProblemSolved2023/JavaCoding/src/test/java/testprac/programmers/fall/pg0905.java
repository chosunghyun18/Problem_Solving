package testprac.programmers.fall;

import java.util.*;
import org.junit.jupiter.api.Test;

public class pg0905 {
    @Test
    public void heap_test(){
        int n = 7 ;
        int k = 3 ;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1} ;
        solution1(n,k,enemy);
    }
    @Test
    public void solQ_test() {
        solutionQ(4);
    }
    int n ;
    int answer ;
    int[] arr;
    public int solutionQ(int n) {
        this.n = n;
        this.arr = new int[n];
        this.answer = 0;
        q(0);
        return answer;
    }
    public void q(int depth) {
        if(depth == this.n) {
            this.answer++;
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i = 0 ; i< n ;i++){
            this.arr[depth] = i ;
            if(isSafe(depth)){
                q(depth + 1);
            }
        }
    }
    public boolean isSafe(int col) {
        for(int i= 0 ; i< col ; i++){
            if(this.arr[col] == this.arr[i]) {return false;}
            else if(Math.abs(col - i ) == Math.abs(this.arr[col] - this.arr[i] ) ) {
                return false;
            }

        }
        return true;

    }
    public int solution1(int n, int k, int[] enemy) {
        int answer = 0 ;

        if(enemy.length <= k) return enemy.length ;
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) ->{return b - a ; });

        for(int i = 0 ; i < enemy.length ; i++) {
            if(k == 0 ) {
                if(enemy[i]  < n ) {
                    n = n-enemy[i] ;
                    answer++;
                }else{
                    return answer ;
                }
            }else {
                for(int j = i ; j < k+i ; j++) {
                    q.add(enemy[j]) ;
                }
                i = i + k - 1 ;
                System.out.println(q) ;
                while(!q.isEmpty()){
                    int check = q.poll();
                    answer++;
                    if(check  > n){
                        if(k > 0){
                            k--;
                        }else{
                            return  answer ;

                        }
                    }else {
                        n = n - check ;
                    }
                }
            }

        } // end for enemy to get item each

        return answer;
    }
    @Test
    public void ballon_test(){

    }










}














