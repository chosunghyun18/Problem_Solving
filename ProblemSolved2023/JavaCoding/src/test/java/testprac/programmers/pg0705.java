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
        solution1(arr1,arr2);
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

    public int[] solution1(int[] progresses, int[] speeds) {
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
    @Test
    void sol_test2() {
        //22:09
        String s = "()()";
        solution11(s);
    }
    boolean solution11(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == '(') {
                stack.addLast(item);
            } else {
                if (stack.isEmpty() || stack.peekLast() != '(') {
                    return false;
                }
                stack.removeLast();
            }
        }

        return stack.isEmpty();
    }

    @Test
    void sol_test3() {
        int[] pr = {1, 1, 9, 1, 1, 1};
        int n = 0;
        solution_others(pr,n);
    }
    public int solution(int[] priorities, int location) {

        // index

        Deque<List<Integer>> deque = new LinkedList<>();

        int[] checkP= new int[10];

        int  count = 1 ;


        for(int i = 0 ; i < priorities.length ;i++) {

            checkP[priorities[i]] += 1 ; // count

            List<Integer> item = new ArrayList<>();
            item.add(i);
            item.add(priorities[i]);
            deque.add(item);
        }
        //item : index : prior
        while(!deque.isEmpty()){
            List<Integer> item = deque.poll();
            int pri = item.get(1);
            int index = item.get(0);
            boolean flag = false;

            for(int i = pri + 1 ;i < 10;i++)
            {
                if(checkP[i] > 0) {
                    deque.add(item);
                    checkP[pri]+=1;
                    count--;
                    flag = false;
                    break;
                }
                flag = true;
            }

            if(flag) {
                if(index == location) {
                    return count;
                }
            }
            checkP[pri]-=1;
            count++;
        }

        return count;
    }

    public int solution_others(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<priorities.length; i++){
            p.add(priorities[i]);
            System.out.println(p);
        }
        System.out.println(p);

        while(!p.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == p.peek()){
                    if(i == location){
                        return answer;
                    }
                    p.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
    @Test
    void sol_test_11(){
        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.add(10);
        p.add(15);
        p.add(16);
        p.add(300);
        System.out.println(p.peek()); // re : 10


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(10);
        pq.add(15);
        pq.add(16);
        pq.add(300);
        System.out.println(pq.peek()); // re : 16
    }
}



