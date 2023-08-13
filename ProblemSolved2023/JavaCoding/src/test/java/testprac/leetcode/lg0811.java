package testprac.leetcode;

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

}




















