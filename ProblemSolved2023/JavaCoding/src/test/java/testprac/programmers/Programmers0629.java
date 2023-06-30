package testprac.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testprac.javacoding.tool.Parser;

public class Programmers0629 {

    private Parser pr;

    public Programmers0629() {
        pr = new Parser();
    }

    @Test
    void sol0() {
        String[] park = {"SOO", "OXX", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};

        String str = "[0,1]";
        int[] ans = pr.parseIntegerList(str);

        assertThat(ans).containsExactly(solution0(park, routes));
    }

    public int[] solution0(String[] park, String[] routes) {

        int sx = 0;
        int sy = 0 ;
        int[] answer  = new int[2] ;
        int n = park[0].length();
        int m = park.length;

        for (int i = 0; i < park.length; i++) {
            String item = park[i];
            int index = item.indexOf('S');
            if (index == -1) {
                continue;
            } else {
                sx = index ;
                sy = i;
            }
        }
        // N  : y - 1
        // S  : y + 1
        // E  : x + 1
        // W  : x - 1

        for(String cmds  : routes) {
            String[] cmd = cmds.split(" ");

            int orx = sx;
            int ory = sy;

            for(int i = 0 ; i < Integer.parseInt(cmd[1]) ; i++) {
                int nx = sx;
                int ny = sy;

                switch (cmd[0]) {
                    case "N" -> ny--;
                    case "S" -> ny++;
                    case "E" -> nx++;
                    case "W" -> nx--;
                }
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || park[ny].charAt(nx) == 'X') {
                    sx = orx;
                    sy = ory;
                    break;
                }
                else {
                    sx = nx;
                    sy = ny;
                }
            }

        }
        answer[0] = sy;
        answer[1] = sx;
        return answer;
    }

    //  14:11 ~
    // 진수의 소수 찾기 + 패턴 파악
    @Test
    void sol1() {

         int n =  437674 ;
         int k = 3 ;

         int expect = 3 ;

        Assertions.assertEquals(expect,solution1(n,k));

    }
    @Test
    void sol1_3() {

        int n = 437674 ;
        int k = 10 ;

        int expect = 0 ;

        Assertions.assertEquals(expect,solution1(n,k));

    }
    @Test
    void sol1_2() {
        int n = 110011;
        int k = 10 ;
        int expect = 2 ;
        Assertions.assertEquals(expect,solution1(n,k));
    }
    @Test
    void sol1_edge() {
        int n = 1;
        int k = 3 ;
        int expect = 0 ;
        Assertions.assertEquals(expect,solution1(n,k));
    }

    public int solution1(int n, int k) {

        String want =  Integer.toString(n,k) ;  // k 진수로 바꾸기

        String[] numbers = want.split("0");
//        System.out.println(Arrays.toString(numbers));
        List<Long> answers  = new ArrayList<>();
        for(String item : numbers) {
            int isPrime = 1;
            if(!item.equals("")) {
                long num = Long.parseLong(item);
                if(answers.contains(num))
                {
                    answers.add(num);
                }
                else{
                    if (num != 1) {
                        for (int i = 2; i * i <= num; i++) {
                            if (num % i == 0) {
                                isPrime = 0;
                                break;
                            }
                        }
                        if (isPrime == 1) {
                            answers.add(num);
                        }
                    }
                }

            }
        }

        return answers.size();
    }
    public int solution1_optimized(int n, int k) {
        String want = Integer.toString(n, k);

        String[] numbers = want.split("0");
        List<Long> primes = new ArrayList<>();

        for (String item : numbers) {
            if (!item.isEmpty()) {
                long num = Long.parseLong(item);
                if (isPrime(num)) {
                    primes.add(num);
                }
            }
        }

        return primes.size();
    }

    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }


}



