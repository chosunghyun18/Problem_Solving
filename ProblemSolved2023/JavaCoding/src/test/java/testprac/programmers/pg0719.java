package testprac.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public class pg0719 {

    @Test
    void think_cache_test() {
        long totalTime = 0;

        for (int i = 0; i < 10000; i++) {
            long startTime = System.nanoTime();

            int[][] values = new int[100][20];
            int sum = 0;
            for (int y = 0; y < 100; y++) {
                for (int x = 0; x < 20; x++) {
                    sum += values[y][x];
                }
            }

            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            totalTime += elapsedTime;
        }

        double averageTime = totalTime / 10000.0;
        System.out.println("Average time for think_cache_test: " + averageTime);
    }

    @Test
    void think_cache_test_2() {
        long totalTime = 0;

        for (int i = 0; i < 10000; i++) {
            long startTime = System.nanoTime();

            int[][] values = new int[100][20];
            int sum = 0;
            for (int x = 0; x < 20; x++) {
                for (int y = 0; y < 100; y++) {
                    sum += values[y][x];
                }
            }

            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            totalTime += elapsedTime;
        }

        double averageTime = totalTime / 10000.0;
        System.out.println("Average time for think_cache_test_2: " + averageTime);
    }
    @Test
    void test_cache(){
        int[][] values = new int[100][20];
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 100; y++) {
                values[y][x] = y;
            }
        }
    }

    @Test
    void job_test() {
        int[] p ={95, 90, 99, 99, 80, 99};

        int[] s = {1, 1, 1, 1, 1, 1} ;
        solution13(p,s);
    }
    public int[] solution13(int[] progresses, int[] speeds) {
        int n = progresses.length ;
        for(int i = 0 ; i <n;i++){
            int left = 100 - progresses[i];
            if(speeds[i] > left){
                progresses[i] = 1;
            }else {
                progresses[i] = (int) Math.ceil((double) left / (double) speeds[i]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();
        for (int progress : progresses) {
            if (!days.isEmpty() && days.peek() < progress) {
                ans.add(days.size());
                days.clear();
            }
            days.add(progress);
        }
        ans.add(days.size());
        return ans.stream().mapToInt(i->i).toArray();
    }
    @Test
    void test_phone(){
        String[] p =  {"119", "97674223", "1143","114344","1195524421"};
        solution(p);
    }
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));
        int n = phone_book.length;
        for(int i = 0 ; i < n-1;i++) {
            String target = phone_book[i];
            String checked = phone_book[i+1];
            if(target.length() > checked.length()){
                continue;
            }
            if(0 == checked.indexOf(target)){
                return false;
            }
        }

        return true;
    }
    @Test
    void q(){
        String a = "1231";
        String b = "12345";
        System.out.println(b.indexOf(a));
    }
}









