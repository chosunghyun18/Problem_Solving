package testprac.leetcode;

import java.util.*;

import org.junit.jupiter.api.Test;

public class lg0810 {

    // coing test prepate 3 ~ 6
    // DB Interview prepare 6:30 ~ 8:00
    // oop ~
    //
    @Test
    public void pal_test(){
        String sen = "0p";
        System.out.println(isPalindrome(sen));
    }
    public boolean isPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            if (Character.isLetter(check)||Character.isDigit(check)) {
                char change = Character.toLowerCase(check);
                ans += change;
            }
        }
        int sizePal = ans.length();
        if(sizePal==0) return true;
        int maxC = (sizePal / 2) ;
        for(int i = 0 ; i < maxC ; i++ ) {
            if( ans.charAt(i) !=ans.charAt(sizePal - 1 - i)) return false;
        }
        return true;
    }
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 2) return new int[]{0,1};
        Map<Integer ,Integer> map = new HashMap<>();
        int index = 0;
        for(int item : numbers) {
            index++;
            int check = target - item ;
            if(map.containsKey(check)){
                return new int[]{index,map.get(check)};
            } else {
                map.put(check,index);
            }
        }
        return new int[]{0,1};
    }
    @Test
    public void triple_sum(){
        int []  nums = {-1,0,1,2,-1,-4} ;
        System.out.println(threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int target = 0 ;

        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0 ; i < n;i++) {
            int first = nums[i];

        }

        return null;
    }

}
