package testprac.programmers.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.print.attribute.standard.PresentationDirection;
import org.junit.jupiter.api.Test;

public class pg0805 {
    @Test
    public void out_test(){
        int[] arrayA = {10, 17}  ;

        int[] arrayB = {5, 20};

        System.out.println(solution1( arrayA,  arrayB));

    }

    public int solution1(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a =0 ;
        int b =0 ;

        for( int i = 0 ;i<arrayA.length ;i++){
            a = gcd(arrayA[i],a);
            b = gcd(arrayB[i],b);
        }

        if(a > 1)  {
            for(int itemB : arrayB) {
                if(itemB % a == 0 ){
                    a = 1;
                    break;
                }
            }
        }
        if(b > 1)  {
            for(int itemA : arrayA) {
                if(itemA % b == 0 ){
                    b = 1;
                    break;
                }
            }
        }
        if(a == 1 && b ==1) {return answer;}
        return Math.max(a,b) ;
    }
    public int gcd(int a , int b) {
        while( b != 0) {
            int tmp = b;
            b = a % b ;
            a = tmp;
        }
        return a;
    }
    @Test
    public void out_test_bfs() {
        int arr[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}} ;
        solution(6,arr);
    }
    public int solution(int n, int[][] edge) {

        boolean[] visited = new boolean[n+1];

        List<List<Integer>> way = new ArrayList<>();
        for(int i =0 ; i < n+1 ; i++) {
            way.add(new ArrayList<>());
        }

        for(int[] item : edge) {
            int left = item[0];
            int right = item[1];
            way.get(left).add(right);
            way.get(right).add(left);
        }
        System.out.println(way);

        int[] distance = new int[n+1];  // 1번 노드로부터의 거리를 저장할 배열

        // bfs
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        while (!q.isEmpty()){
            int cuurNode = q.poll();
            for(int nextNode : way.get(cuurNode)) {
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    q.offer(nextNode);
                    distance[nextNode] = distance[cuurNode] + 1;
                }
            }
        }

        // return number of node , which max far from number 1 :
        int maxDistance = Arrays.stream(distance).max().getAsInt();
        long count = Arrays.stream(distance).filter(d -> d == maxDistance).count();

        return (int) count;
    }
    @Test
    public void showJump() {
        int[] nums =  {3,2} ;
        canJump(nums);
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return true;
        boolean reachable  =  false;

        int least = 1 ;

        for( int i = n -2 ; i > -1; i--) {
            int check  = nums[i];
            if(check  >= least){
                reachable = true;
                least = 1;
            }else {
                reachable = false;
                least++;
            }
        }
        return  reachable ;
    }
    int[] parent = new int[12] ;
    public int findp(int n ) {
        if(n == parent[n]) return  n ;
        return parent[n] = findp(n) ;
    }
    public boolean union(int a , int b) {
        a = findp(a);
        b = findp(b) ;
        if(a != b) {
            parent[b] = a ;
            return true ;
        }
        return  false ;
    }
    public int sol12(int n , int[][]costs) {
        int  ans = 0 ;

        parent = new int[n] ;

        for(int i = 0 ; i < n ; i++ ) {
            parent[i] =  i ;
        }

        Arrays.sort(costs,Comparator.comparingInt( o -> o[2]));
        for(int[] item : costs){
            if(union(item[0],item[1])){
                ans += item[2];
            }
        }

        return ans ;
    }


}























