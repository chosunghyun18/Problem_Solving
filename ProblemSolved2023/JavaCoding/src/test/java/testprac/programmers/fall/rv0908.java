package testprac.programmers.fall;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class rv0908 {
    @Test
    public void union_find_test(){
        int n = 4 ;
        int[][] costs = {
                {0,1,1},
                {0,2,2},
                {1,2,5},
                {1,3,1},
                {2,3,8}
        };
        sol(n,costs);
    }
    public int findParent(int node) {
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
    int [] parent;
    public boolean union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a != b) {
            parent[b] = a;
            return true;
        }
        return false;
    }
    public int sol(int n , int[][] costs) {
        parent = new int[n];
        for(int i = 0 ; i <n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs,(a,b)->{return a[2] - b[2] ; });
        int answer = 0;
        for(int[] item : costs) {
            if(union(item[0],item[1])) answer += item[2];
        }
        return answer;
    }

}























