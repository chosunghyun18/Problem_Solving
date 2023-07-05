package testprac.programmers;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.Test;
import testprac.javacoding.tool.Parser;

public class pg0705 {

    public  pg0705() {
        Parser parser = new Parser();
    }


    @Test
    void sol_test1() {
        int[] arr1 = {0, 0, 55};
        int[] arr2 = {100, 1, 5};
        solution(arr1,arr2);
    }

    public int[] solution1(int []arr) {
        int check = arr[0];
        List<Integer> store = new ArrayList<>();
        for(int item : arr ){
            if(item != check) {
                store.add(item);
                check = item;
            }
        }
        return store.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution(int[] progresses, int[] speeds) {
        // [93, 30, 55]    ,    [1, 30, 5]    : [2, 1]
        // [95, 90, 99, 99, 80, 99]	 ,  [1, 1, 1, 1, 1, 1]  :  [1, 3, 2]
        int arrSize = progresses.length;
        int[] defineProgress = new int[arrSize];

        for(int i = 0; i< progresses.length;i++){
            double left = (double) 100 - (double) progresses[i] ;
            defineProgress[(progresses.length-1) - i] = (int)Math.ceil(left/speeds[i]);
        }

        int tmp = defineProgress[0];
        int count =1;
        List<Integer> ans  = new ArrayList<>();
        for(int i = 1 ; i <arrSize;i++){
            if(defineProgress[i] > tmp){
                tmp = defineProgress[i];
                count++;
            } else if (defineProgress[i] < tmp) {
                ans.add(count);
                count = 1 ;
                tmp = defineProgress[i];
            }
            else count++;
        }

        ans.add(count);
        Collections.reverse(ans);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
