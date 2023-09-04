package testprac.programmers.spring;

import static java.util.Comparator.*;

import java.util.Arrays;

import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testprac.javacoding.tool.Parser;

public class pg0706 {

    public String solution1(String s) {
        String[] numberGiven = s.split(" ");

        int[] numbers = new int[numberGiven.length];


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < numberGiven.length ; i++ ) {
            numbers[i] = Integer.parseInt(numberGiven[i]);
            if(numbers[i] < min) min = numbers[i];
            if(numbers[i] > max) max = numbers[i];
        }
        s  =min+" "+ max;

        System.out.println(s);
        return s;
    }
    public String solution12(String s) {
        // "3people unFollowed me"  - >  "3people Unfollowed Me  "
        String[] split = s.split(" ");
        if(split.length == 0) return s;

        String[] splitc = s.split("");
        String check = splitc[splitc.length -1 ];

        String ans = "";
        for(String item : split) {
            if(item.equals(" ")) ans += item;
            String[] items = item.split("");

            try{
                Integer.parseInt(items[0]); // start with nuber
                ans += items[0];
                for(int i = 1 ; i < items.length;i++) {
                    try{
                        Integer.parseInt(items[i]);
                        ans += items[i];
                    }
                    catch (NumberFormatException ex){
                        ans += items[i].toLowerCase();
                    }

                }

            }catch (NumberFormatException ex) {
                ans += items[0].toUpperCase();
                for (int i = 1; i < items.length; i++) {
                    ans += items[i].toLowerCase();
                }
            }
            ans += " ";
         }

        if(check.equals(" "))
            //
            return ans;
        else return ans.trim();
    }

    public int solution13(int[] A, int[] B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0 ; i < A.length;i++){
            answer += (A[i]*B[A.length-1-i]) ;
        }
        return answer;
    }


    public int[] solution(String s) {
        int[] answer = new int[2];
        int numZero = 0 ;
        int numChanged = 0;
        while(!s.equals("1"))
        {   numChanged++;
            String[] sarr = s.split("");
            for(String digit : sarr) {
                if(digit.equals("0")) numZero++;
            }
            s = s.replaceAll("0","");
            int convreted = s.length();
            s = Integer.toBinaryString(convreted);
        }

        answer[0] = numChanged;
        answer[1] = numZero;

        System.out.println(numChanged);
        System.out.println(numZero);
        return answer;
    }

}








