package testprac.programmers.spring;

import java.util.*;
import org.junit.jupiter.api.Test;

public class pg0816 {
    @Test
    public void escape_maze(){
        String [] maze =  {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}  ;
        System.out.println(solution(maze));
    }
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    public int solution(String[] maps) {
        int startX = 0 ,startY =0 , lerverX =0 , leverY = 0 ;
        for(int i= 0 ; i < maps[i].length() ; i++){
            for( int j = 0 ; j < maps.length ; j++) {
                if(maps[i].charAt(j)=='S') {
                    startX = i;
                    startY =  j ;
                }
                if(maps[i].charAt(j)=='L') {
                    lerverX = i ;
                    leverY =  j ;
                }
            }
        }
        int sToL = bfs(maps,startX,startY,'L');
        int lToE = bfs(maps,lerverX,leverY,'E');
        if(sToL == -1 || lToE == -1) return -1;
        return sToL + lToE ;
    }
    public int bfs(String[] maps,int x, int y,char target) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x,y,0));
        visited[x][y] = true;
        while (!q.isEmpty()){
            Position current = q.poll();
            for(int i = 0  ; i < 4 ; i++){
                int nx = current.x +dx[i];
                int ny = current.y +dx[i];

            }
        }
        return  -1 ;
    }
    static class Position {
        int x, y, dist;

        Position(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public  int bfss(String[] maps, int startX, int startY, char target) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && maps[newX].charAt(newY) != 'X' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    if (maps[newX].charAt(newY) == target) {
                        return current.dist + 1;
                    }
                    queue.add(new Position(newX, newY, current.dist + 1));
                }
            }
        }
        return -1;  // No path found
    }
    @Test
    void sol_test(){
        int[] cards = {2, 3, 4, 5, 6, 7, 8, 9, 10 , 1 };
        solution(cards);
    }
    private int[] cards ;
    private boolean[] visit;
    public int solution(int[] cards) {
        int multi = 1;
        int n = cards.length;
        this.cards = cards;
        visit = new boolean[n];
        List<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < n ;i++) {
            int count = 0;
            int start = cards[i] - 1 ;
            if(!visit[i]) {
                count = visitA(start,count);
                arr.add(count);
            }
        }
        if(arr.size() ==1) return 0;
        arr.sort((a,b) -> b-a);
        return arr.get(0)*arr.get(1);
    }
    public int visitA(int position,int count) {
        if(visit[position]){
            return count;
        }else{
            count++;
            visit[position] = true;
            return visitA(cards[position]-1,count);
        }
    }
    @Test
    void longest_String_search()
    {
        String s = "abacde"; // 3
        solution(s);
    }
    public int solution(String s)
    {
        int count = 1 ;
        List<Integer> answ = new ArrayList();
        for(int i = 0 ; i < s.length() ; i++) {
            boolean flag = false ;
            while(!flag) {
                if(i-count != -1 && i+count < s.length()){
                    if(s.charAt(i-count) == s.charAt(i+count)) {
                        count++;
                    }else{
                        answ.add(count);
                        count = 1;
                        flag = true;
                    }
                }else{
                    flag = true;
                }
            }
            answ.add(count);
            count = 1;
        }
        answ.sort((a,b) -> b-a);
        return (answ.get(0)*2 -1);
    }

}
