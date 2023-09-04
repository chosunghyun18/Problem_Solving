package testprac.programmers.spring;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testprac.javacoding.tool.Parser;


public class Programmers0703 {

    private Parser pr;

    public Programmers0703() {
        pr = new Parser();
    }

    @Test
    void sol1() {
        String sInfo = "[4, 1, 2, 1]";
        int[] numbers = pr.parseIntegerList(sInfo);
        int target = 4;

        int expect = 2;
        int result = solution1(numbers, target);
        Assertions.assertEquals(expect, result);
    }

    public int solution1(int[] numbers, int target) {
        return countCombinations(numbers, target);
    }

    private Map<String, Integer> memo = new HashMap<>();

    public int countCombinations1(int[] numbers, int target, int index, int sum) {
        String key = index + ":" + sum;

        if (memo.containsKey(key)) {  // 같은 인덱스와  sum 이면  계산 x 같은  결과

            return memo.get(key);
        }

        if (index == numbers.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int positive = countCombinations1(numbers, target, index + 1, sum + numbers[index]);
        int negative = countCombinations1(numbers, target, index + 1, sum - numbers[index]);

        int total = positive + negative;
        memo.put(key, total);

        return total;
    }

    public int countCombinations(int[] numbers, int target) {
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int index = current.getIndex();
            int sum = current.getSum();
            if (index == numbers.length) {
                if (sum == target) {
                    count++;
                }
                continue;
            }
            q.offer(new Pair(index + 1, sum + numbers[index]));
            q.offer(new Pair(index + 1, sum - numbers[index]));

        }
        return count;
    }

    private static class Pair {

        private int index;
        private int sum;

        public Pair(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }

        public int getIndex() {
            return index;
        }

        public int getSum() {
            return sum;
        }
    }

    @Test
    void sol2() {
        String sInfo = "[[1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 1], [0, 0, 0, 0, 1]]";
        int[][] numbers = pr.parseIntegerDoubleList(sInfo);

        int expect = 11;
        int result = solution2(numbers);
        Assertions.assertEquals(expect, result);
    }

    @Test
    void sol3() {

        int[][] numbers = {{1}};

        int expect = 1;
        int result = solution2(numbers);
        Assertions.assertEquals(expect, result);
    }

    public int solution2(int[][] maps) {
        int y = maps.length;
        int x = maps[0].length;

        if (x == 1 && y == 1) {
            if (maps[0][0] == 0)
                return -1;
            else
                return 1;
        }
        if (maps[0][1] == 0 && maps[1][0] == 0)
            return -1;

        int inf = Integer.MAX_VALUE;

        int[][] way = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int[][] cost = new int[y][x];
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                if (maps[j][i] == 1)
                    cost[j][i] = inf;
            }
        }
        boolean[][] visit = new boolean[y][x];

        cost[0][0] = 1;

        Queue<String> q = new LinkedList<>();

        String start = "0:0"; // x : y : value
        visit[0][0] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            String[] currCord = q.remove().split(":");// split and int parse
            int currX = Integer.parseInt(currCord[0]);
            int currY = Integer.parseInt(currCord[1]);
            int currCost = cost[currY][currX];
            for (int i = 0; i < 4; i++) {
                int nx = currX + way[i][0];
                int ny = currY + way[i][1];
                if (check(maps, visit, x, y, nx, ny)) {
                    String item = nx + ":" + ny;
                    visit[ny][nx] = true;
                    q.offer(item);
                    if (currCost + 1 < cost[ny][nx]) {
                        cost[ny][nx] = currCost + 1;
                    }
                }
            }
        }
        if (visit[y - 1][x - 1])
            return cost[y - 1][x - 1];
        return -1;

    }

    public boolean check(int[][] maps, boolean[][] visit, int maxX, int maxY, int currX,
        int currY) {
        if (maxX <= currX || currX <= -1 || maxY <= currY || currY <= -1) {
            return false;
        }
        if (maps[currY][currX] == 0)
            return true;

        if (visit[currY][currX])
            return false;

        return true;
    }

    // bfs 풀이 오류 없는 정답 코드
    public int solution(int[][] maps) {
        int y = maps.length;
        int x = maps[0].length;

        int[][] way = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int[][] cost = new int[y][x];
        for (int[] row : cost) {
            Arrays.fill(row, -1);
        }

        cost[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] currCord = q.remove();
            int currX = currCord[0];
            int currY = currCord[1];
            int currCost = cost[currY][currX];

            for (int i = 0; i < 4; i++) {
                int nx = currX + way[i][0];
                int ny = currY + way[i][1];

                if (nx >= 0 && nx < x && ny >= 0 && ny < y && maps[ny][nx] == 1
                    && cost[ny][nx] == -1) {
                    cost[ny][nx] = currCost + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return cost[y - 1][x - 1];
    }
    @Test
    void sol21() {
        int[] given = pr.parseIntegerList("[2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]");
        int n = 5;
        solution10(n,given);
    }
    public  ArrayList<int[]> list = new ArrayList<int[]>();
    public  int max_diff = -1;
    public  int[] ryan;
    public  int[] apeach;
    public int[] solution10(int n, int[] info) {
        int[] answer = {} ;
        ryan = new int[11];
        apeach = info;
        dfs_sol10(n,0,0);
        if(max_diff == -1) return new int[]{-1};
        Collections.sort(list, (o1, o2) -> {
            for(int i=10;i>=0;i--){
                if(o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });

        return list.get(0);
    }
    public void dfs_sol10(int n , int depth,int start){
        if(depth == n){
            int a_sum = 0 ;
            int r_sum = 0 ;
            for(int i = 0 ; i <10 ; i++){
                if(apeach[i] == 0 && ryan[i] == 0) continue;
                if(apeach[i] >= ryan[i]) a_sum += (10-i);
                else r_sum += (10-i);
            }

            if(r_sum > a_sum){
                int diff = r_sum - a_sum;
                if(max_diff < diff){
                    max_diff = diff;
                    list.clear();
                    list.add(ryan.clone());
                } else if(max_diff == diff){
                    list.add(ryan.clone());
                }
            }

            return;
            }

        for(int i=start;i<11;i++){
            ryan[i]++;
            dfs_sol10(n, depth+1, i);
            ryan[i]--;
        }
    }
}

























