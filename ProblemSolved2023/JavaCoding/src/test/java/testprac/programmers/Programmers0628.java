package testprac.programmers;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class Programmers0628 {
    public Programmers0628(){

    }
    public int[] parseIntegerList(String str) {
        str = str.replaceAll("\\[|\\]|\\s", "");
        String[] elements = str.split(",");
        int size = elements.length;
        int[] re = new int[size];

        for (int i = 0; i < size; i++) {
            re[i] = Integer.parseInt(elements[i]);
        }

        return re;
    }

    @Test
    void sol3(){

        String[] park = {"SOO","OXX","OOO"};
        String[] routes ={"E 2","S 2","W 1"};

        System.out.println(Arrays.toString(sol3(park,routes)));
    }
    public int[] sol3(String[] park, String[] routes) {
        int[] answer = new int[2];
        int sx = 0;
        int sy = 0;

        int n = park[0].length();
        int m = park.length;

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (park[y].charAt(x) == 'S') {
                    sx = x;
                    sy = y;
                    break;
                }
            }
        }

        for (String cmdScript : routes) {
            String[] cmd = cmdScript.split(" ");
            int orx = sx;
            int ory = sy;

            for (int i = 0; i < Integer.parseInt(cmd[1]); i++) {
                int nx = sx;
                int ny = sy;

                switch (cmd[0]) {
                    case "E" -> nx++;
                    case "W" -> nx--;
                    case "S" -> ny++;
                    case "N" -> ny--;
                }

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || park[ny].charAt(nx) == 'X') {
                    sx = orx;
                    sy = ory;
                    break;
                } else {
                    sx = nx;
                    sy = ny;
                }
            }
        }

        answer[0] = sy;
        answer[1] = sx;
        return answer;
    }

    @Test
    void sol5(){

        int n = 8;
        int a = 4;
        int b = 7;
        int re = solution5(n,a,b);
        Assertions.assertEquals(3,re);

        n = 6;
        a = 1;
        b = 2;
        re = solution5(n,a,b);
        Assertions.assertEquals(1,re);
    }
    public int solution5(int n, int a, int b) {
        int answer = 0 ;
        //  2 로 나눈 몫 + 나머지 = 다음 그룹
        int flag = 0 ;
        int round = 1 ;
        while (flag == 0) {
            //check same group
            int a_next = (a / 2) + (a % 2);
            int b_next = (b / 2) + (b % 2);

//            int a_head =  a / 2 ;
//            int a_tail =  a % 2 ;
//
//            int b_head =  b / 2 ;
//            int b_tail =  b % 2 ;

            if(a_next == b_next ) {
                flag = 1;
                answer  = round;
            }else {
                round+=1;
                a = a_next;
                b = b_next;
            }

        }
        return answer;
    }
    @Test
    void sol6(){

        int brown = 10;

        int yellow = 2 ;

        int[] re = solution6(brown,yellow);

        String str = "[4, 3]";

        int[] ans = parseIntegerList(str);

        assertThat(ans).containsExactly(re);

        brown = 8;

        yellow = 1 ;

        re = solution6(brown,yellow);

        str = "[3, 3]";

        ans = parseIntegerList(str);

        assertThat(ans).containsExactly(re);

    }
    public int[] solution6(int brown, int yellow) {
        int [] answer = new int[2];
        // 노란 색 가능한거 , 나누고 각각+1 *2 = brown
        int flag = 0 ;
        int checkT = brown / 2;
        int yCol;
        int yRow;
        while(flag == 0)
        {
            for(int i = 1 ; i<=yellow;i++) {
                if(yellow % i == 0 ) {
                    yCol = i ;
                    yRow = yellow / i;
                    if(yCol > yRow) {
                        flag = 1 ;
                        break;
                    }
                    if( (yCol+ yRow +2) == checkT) {
                        answer[0] = yRow + 2;
                        answer[1] = yCol + 2;
                        return answer;
                    }
                }
            }
            flag = 1 ;
        }

        return answer;
    }
    @DisplayName("next int")
    @Test
    void sol7(){
//        int n = 78;
//        int re = solution7(n);
//        Assertions.assertEquals(83,re);

        int n = 15;
        int re = solution7(n);
        Assertions.assertEquals(23,re);
    }
    public int solution7Brutal(int n) {
        int answer = 0 ;
        int flag = 0 ;
        String given = Integer.toBinaryString(n);
        int numberOneGiven = given.replaceAll("0","").length();

        while (flag == 0 )
        {
            n += 1;
            String check = Integer.toBinaryString(n);
            int numberOneCheck = check.replaceAll("0","").length();
            if(numberOneCheck == numberOneGiven) {
                return (n);
            }

        }
        return answer;
    }
    public int solution7(int n) {
        int answer = 0;
        String given = Integer.toBinaryString(n);
        System.out.println(given);
        int onesCount = given.replaceAll("0", "").length();
        int zerosCount = given.replaceAll("1", "").length();

        List<String> lists = generatePermutations(onesCount, zerosCount);

        TreeMap<Integer, Integer> map = new TreeMap<>(); // tree map is sorted by value

        int count = 0;
        for (String item : lists) {
            int value = Integer.parseInt(item, 2);
            map.put(value, count);
            count += 1;
        }
        // 모든 entry 출력
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        int target = n + 1;
        Map.Entry<Integer, Integer> entry = map.ceilingEntry(target);
        if (entry != null) {
            answer = entry.getKey();
        }
        if(answer == 0 ){
            String reg = given.replaceFirst("1","10");
            System.out.println(reg);
            answer =Integer.parseInt(reg, 2);
            return answer;
        }
        return answer;
    }
    private static List<String> generatePermutations(int onesCount, int zerosCount) {
        List<String> permutations = new ArrayList<>();
        StringBuilder binaryString = new StringBuilder();

        // 1 추가
        for (int i = 0; i < onesCount; i++) {
            binaryString.append("1");
        }

        // 0 추가
        for (int i = 0; i < zerosCount; i++) {
            binaryString.append("0");
        }

        // 가능한 모든 순열 생성
        generatePermutationsHelper("", binaryString.toString(), permutations);

        return permutations;
    }

    private static void generatePermutationsHelper(String prefix, String remaining, List<String> permutations) {
        if (remaining.length() == 0) {
            permutations.add(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutationsHelper(newPrefix, newRemaining, permutations);
        }
    }
    public int solution7Ans(int n) {
        int bitCount = Integer.bitCount(n);
        while(true){
            if(bitCount == Integer.bitCount(++n)){
                break;
            }
        }
        return n;
    }
    @Test
    void sol8(){
        int n = 3;
        Assertions.assertEquals(2,solution8(n));
        n = 5;
        Assertions.assertEquals(5,solution8(n));
    }
    public int solution8(int n) {
        int[] fib = new int[ n + 1];
        fib[0] = 0 ;
        fib[1] = 1 ;
        fib[2] = 1 ;
        if (n == 2) {
            return  1 ;
        }
        else {
            for(int i = 2 ;i < n + 1;i++) {
                fib[i] = (fib[i - 1] + fib[i - 2]) % 1234567;
            }
            return fib[n];
        }
    }
    @Test
    void sol9() {
        String str = "4 1";
        String[] given = str.split(" ");
        int n = Integer.parseInt(given[0]);
        int m = Integer.parseInt(given[1]);

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[ n + 1 ];

        sol9dfs(n,m,result,visited) ;

    }
    private void sol9dfs(int n, int m, List<Integer> result, boolean[] visited) {
        if(m == result.size()){
            for( int  item : result) {
                System.out.print(item + " ");
            }
            return;
        }

        for(int i = 0 ; i <=n ;i++) {
            if(!visited[i]){
                visited[i] = true;
                result.add(i);
                sol9dfs(n,m ,result,visited) ;
                result.remove(result.size() -1 );
                visited[i] = false;
            }
        }
    }

    int[][] graph =   {
        {0, 0, 1, 1, 0}
        ,{0, 0, 0, 1, 1}
        ,{1, 1, 1, 1, 1}
        ,{0, 0, 0, 0, 0}
    };

    int n = 4, m = 5;

    @Test
    public void iceCubeTest() {

        // quest : 1 은 막혀있고 만들 수 있는 총 얼음의 개수
        int res = 0 ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행
                if (iceDfs(i, j)) {
                    res += 1;
                }
            }
        }
        System.out.println(res); // 정답 출력

    }
    public Boolean iceDfs(int x, int y ) {
        // out of range
        if (x <= -1 || x >=n || y <= -1 || y >= m) {
            return false;
        }
        // recursion visit graph
        if(graph[x][y] == 0 ) {
            graph[x][y] = 1;
            iceDfs(x - 1, y);
            iceDfs(x, y - 1);
            iceDfs(x + 1, y);
            iceDfs(x, y + 1);
            return true;
        }
        return false;
    }
}










