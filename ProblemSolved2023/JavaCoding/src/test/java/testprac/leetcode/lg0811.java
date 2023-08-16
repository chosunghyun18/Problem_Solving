package testprac.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class lg0811 {


    @Test
    public void palinDrome_Test(){
        String s = "ab" ;
        isPalindrome(s);
    }


    public boolean isPalindrome(String s) {
        if(s.length() == 1) return true;
        int left = 0 , right = s.length() -1 ;
        while (left <= right){
            while (left < right && !Character.isLetterOrDigit((s.charAt(left)))){
                left++ ;
            }
            while (left < right && !Character.isLetterOrDigit((s.charAt(right)))){
                right-- ;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false ;

            left++ ;
            right--;
        }
        return true ;
    }
    @Test
    void two_pointer_two_sum_test(){
        int[] numbers = {2,7,11,15} ;
        int t = 9 ;
        int[] re = twoSum(numbers,t);

    }
    public int[] twoSum(int[] numbers, int target) {
        int left = 0 , right = numbers.length - 1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target) return new int[]{left+1,right+1};
            if(sum > target) right--;
            if(sum < target) left++;
        }
        return new int[]{};
    }
    @Test
    public void three_sum_test(){
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0 ;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> re = new ArrayList<>();

        for(int i = 0 ; i < nums.length;i++){
            int j = i+1 ;
            int k = nums.length -1 ;
            while( j< k ){
                int sum = nums[i] +nums[j] +nums[k] ;
                if(sum == target) {
                    s.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return re ;
    }


}




















