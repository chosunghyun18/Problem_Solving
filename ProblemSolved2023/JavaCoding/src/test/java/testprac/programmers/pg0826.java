package testprac.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;

import java.util.Set;
import org.junit.jupiter.api.Test;

public class pg0826 {

    @Test
    public void three_sum_test(){
        int[] nums = {-1,0,1,2,-1,-4} ;
        System.out.println(threeSum(nums));
    }

    // find sets of integer list which make sum is  0

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0 ;

        int n = nums.length  ;
        int c = n - 1 ;
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0 ; i  < n -1 ;i++) {
            int a = i ;
            int b = a + 1;
            while(c > b) {
                int sum = nums[a] + nums[b] + nums[c] ;

                if(sum == target)
                {
                    ans.add(List.of(nums[a],nums[b],nums[c]));
                    c--;
                    b++;
                } else if (sum > target) {
                    c--;
                }else {
                    b++;
                }
            }
        }

        List<List<Integer>> re = new ArrayList<>();
        re.addAll(ans);
        return re;
    }
    // if a or b is 0 return
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
