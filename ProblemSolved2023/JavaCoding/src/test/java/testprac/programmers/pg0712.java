package testprac.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public int solution1_1(String s) {
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

    @Test
    void sol_2() {
        int n = 2 ;
        String[] words =  {"hello", "one", "even", "never", "now", "world", "draw"} ;
        System.out.println(
            Arrays.asList(solution(n,words))
        );

    }

    public int[] solution(int n, String[] words) {
        List<List<String>>  people = new ArrayList<>();
        //make grid
        for(int i = 0 ;i  < n ; i++){
            List<String> tmp  = new ArrayList<>();
            people.add(tmp);
        }
        int [] answer =new int [2];

        people.get(0).add(words[0]);
        // init
        int flag = 0 ;
        int flagIndex = 0 ;
        for(int i = 1 ; i < words.length ; i++){
            int index = n % i  ;
            List<String> tmp  =  people.get(index);
            String check =  words[i] ;

            if(check.toCharArray()[check.length()-1] == words[i-1].toCharArray()[0]){

            }
            else{
                flag = i;
                flagIndex = index;
                break ;
            }
        }

        answer[0] = flag;
        answer[1] = flagIndex;
        return answer;
    }


}

























