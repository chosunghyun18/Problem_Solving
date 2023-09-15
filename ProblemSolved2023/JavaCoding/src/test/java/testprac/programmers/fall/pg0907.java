package testprac.programmers.fall;

import java.util.* ;


import org.junit.jupiter.api.Test;

public class pg0907 {
    // Test for all grammer
    @Test
    public void arr_test() {
        Stack<Integer> s =  new Stack<>();
        s.push(1);
        int stackItem = s.pop();
        System.out.println(stackItem);

        Map<Integer,Integer> map = new HashMap<>() ;
         for(int i = 0 ; i < 4;i++){
             map.put(i,i);
         }
         for(Map.Entry<Integer,Integer> item : map.entrySet()){
             int key = item.getKey();
             int value = item.getValue();
             System.out.println(key);
             System.out.println(value);
         }

        int[][] arr = {{1,2},{1,2,},{3,2}};
        Arrays.sort(arr,(a,b) -> {
            if(a[0] == b[0]) return  b[1] - a[1] ;
            return b[0]  - a[0] ;
        });

        System.out.println(Arrays.deepToString(arr));
        Queue<Map<Integer,Integer>> q = new LinkedList<>();
        for(int i = 0 ;i<5 ;i++){
            Map<Integer,Integer> m = new HashMap<>();
            m.put(i,i);
            q.add(m);
        }
        System.out.println(q);

    }

}
