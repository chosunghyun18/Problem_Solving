package testprac.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class pg0717 {

    @Test
    void test_sol(){
        int m = 4;
        int n = 3 ;
        int[][] puddles = {{2,1}} ;
        System.out.println(solution(m,n,puddles));
    }
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;

        int[][] board = new int[n + 1][m + 1];
        for(int i = 0; i < puddles.length; i++) {
            board[puddles[i][1]][puddles[i][0]] = -1;
        }

        board[1][1] = 1;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(board[i][j] == -1) continue;
                if(board[i - 1][j] > 0) board[i][j] += board[i - 1][j] % mod;
                if(board[i][j - 1] > 0) board[i][j] += board[i][j - 1] % mod;
            }
        }
        return board[n][m] % mod;
    }

    @Test
    void test_left(){

        int div = 1_000_000_007;
        for(int i = 1 ; i< 15 ;i++) {
            System.out.println(i%div);
        }

    }
    public int solution1(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int location = routes[0][1];
        int answer = 1;

        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > location) {
                answer++;
                location = routes[i][1];
            }
        }
        return answer;

    }
    @Test
    void test_left_12(){
        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};
        int r = solution(a,b);
        System.out.println(r);
    }
    public int solution(int[] A, int[] B) {
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        Integer[] b = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(b, Collections.reverseOrder());
        int countA = 0 ;
        int countB = 0 ;

        for(int i = 0 ;i < n ;i++){
            if(A[i] < b[i]){
                countA++;
            }
        }
        for(int i = 0 ;i < n ;i++){
            if(A[i] < B[i]){
                countB++;
            }
        }

        return Math.max(countA,countB);
    }
    @Test
    void test_left_123(){
        int n = 11 ;
        int [] arr = {4, 11};
        int  w =1 ;
        int re = solution12(n,arr,w);
        System.out.println(re);

    }
    public int solution123(int n, int[] stations, int w) {
        // 1 부터 n 까지의 숫자중에 남아있는 숫자중 연속하는 숫자의 중간값

        int[] apt = new int[n];
        for(int ant: stations) {
            apt[ant -1] = 1;
            int cent = ant -1 ;
            for(int i = 1;i<=w;i++) {
                if(cent - i >= 0){
                    apt[cent - i] = 1 ;
                }
                if(cent + i < n ){
                    apt[cent + i ] = 1;
                }
            }
        }

        int tmp = 0;
        int countRouter = 0 ;

        for(int index = 0 ; index < n ; index++) {
            if(apt[index] == 1 && tmp == 0) {
                continue;
            }else if (apt[index] == 1 && tmp != 0){
                countRouter++;
                int cent = index - 1 ;
                for(int i = 1;i<=tmp;i++) {
                    if(cent - i >= 0) {
                        apt[cent - i] = 1 ;
                    }
                }
                tmp = 0;
                continue;
            }
            if(tmp + 1 == ((2*w) + 1) ) {
                int cent = index ;
                countRouter++;
                for(int i = 1;i<=w;i++) {
                    if(cent - i >= 0) {
                        apt[cent - i] = 1 ;
                    }
                }
                tmp = 0;
            }else{
                tmp++;
            }
        }
        if(tmp > 0) {
            countRouter++;
        }

        return countRouter ;
    }
    public int solution12(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;
        int position = 1;

        while(position <= n) {
            if(idx < stations.length && stations[idx] - w <= position) {
                position = stations[idx] + w + 1;
                idx++;
            } else {
                position += w * 2 + 1;
                answer++;
            }
        }
        return answer;
    }
}




















