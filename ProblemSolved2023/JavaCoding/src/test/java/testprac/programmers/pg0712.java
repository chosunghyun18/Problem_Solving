package testprac.programmers;

import java.util.Stack;
import org.junit.jupiter.api.Test;
import testprac.javacoding.TestObject;

public class pg0712 {

    @Test
    void sols3(){
        TestObject testObject = new TestObject(1);
        TestObject copy = testObject;
        copy.setNumber(12);
        System.out.println(testObject.getNumber());

    }
    @Test
    void sol_2() {
        String given = "baabaa";
        int an = solution(given);
    }

    public int solution1(String s) {
        int answer = 0 ;

        while (s.length() != 0 ) {
            int check = s.length();
            if(s.length() == 1) return answer ;
            char tmp  =  s.charAt(0);
            int range = s.length();
            for(int i = 1 ; i < range ;i++) {
                if(tmp == s.charAt(i)){
                    s = s.substring(0,i-1) +s.substring(i+1);
                    range = range -2 ;
                    i = i-1;
                    tmp = 'A';
                }else{
                    tmp = s.charAt(i);
                }

            }
            if(check ==s.length()) return 0;

        }
        answer =  1;
        return answer;
    }

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

}

























