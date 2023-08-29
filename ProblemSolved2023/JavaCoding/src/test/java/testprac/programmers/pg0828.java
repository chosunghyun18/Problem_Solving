package testprac.programmers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class pg0828 {
    @Test
    public void bot(){
        String[] arr = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."} ;
        System.out.println(solution1(arr));
    }
    public int solution1(String[] board) {
        int answer = -1;
        int rowSize = board.length;
        int colSize = board[0].length();

        int startR = 0 , startC = 0  , er = 0,ec = 0 ;


        for(int r = 0; r < rowSize;r++) {
            for(int c = 0 ; c<colSize;c++) {
                if(board[r].charAt(c) == 'R')
                {
                    startR = r;
                    startC = c ;

                }
                if(board[r].charAt(c) == 'D')
                {
                    er = r;
                    ec = c ;

                }
            }
        }
        // 출발 가능 및 도착 가능 검증 생략 . index +1 ;
        int[][] way = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rowSize][colSize];

        q.offer(new int[]{startR, startC,0});  // x, y, direction, moves


        while (!q.isEmpty()) {
            int[] currCord = q.remove();
            int currR = currCord[0];
            int currC = currCord[1];
            int currMove = currCord[2] ;

            if(er == currR && ec == currC) {
                return currMove;
            }

            System.out.println(currR+":cur:"+currC);
            for(int i = 0 ; i < 4; i++) {
                int nx = currR ;
                int ny = currC ;

                for(int k=1;k<=Math.max(rowSize,colSize);k++) {
                    currR+= way[i][0];
                    currC+= way[i][0];
                    if(nx < 0 || nx >= rowSize || ny < 0 || ny >= colSize || board[nx].charAt(ny) =='D') {
                        currR-= way[i][0];
                        currC-= way[i][0];
                        break;
                    }
                }
                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,i,currMove+1});  // visited
                }
            }
        return -1;
    }
    @Test
    public void suttle_test1(){
        int n = 1, t = 1, m = 5 ;
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"}; // 9 시에  운행 1 대 ,  1 분 간격으로 오고 , 총 5 명 탑승 , 즉 콘은 9시 정각에 탑승
        String an = solution(n,t,m,timetable);
        System.out.println(an); // 9:9
    }
    @Test
    public void suttle_test2(){
        int n = 2, t = 10, m = 2 ;
        String[] timetable = {"09:10", "09:09", "08:00"} ;  // if con arrive at 9 : 10 : late
        String an = solution(n,t,m,timetable);
        System.out.println(an); // 9:9
    }
    @Test
    public void suttle_test3(){
        int n = 2, t = 1, m = 2;
        String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
        String an = solution(n,t,m,timetable);
        System.out.println(an); // 8:59

    }
    @Test
    public void suttle_test4(){
        int n = 1, t = 1, m = 5;
        String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        String an = solution(n,t,m,timetable);
        System.out.println(an);
    }
    @Test
    public void suttle_test5(){
        int n = 1, t = 1, m = 1 ;
        String[] timetable = {"23:59"}; // 9시에 버스 도착
       // String[] timetable = {"8:59"}; //
        String an = solution(n,t,m,timetable);
        System.out.println(an);
    }


    public String solution(int n, int t, int m, String[] timetable) {
        System.out.println("timeT : "+Arrays.toString(timetable));
        int[] times = new int[timetable.length];
        int indext = 0 ;
        for(String time : timetable){
            String [] timeItem = time.split(":");
            int h = Integer.parseInt(timeItem[0]);
            int min = Integer.parseInt(timeItem[1]);
            times[indext] = (h*60) + min ;
            indext++;
        }
        Arrays.sort(times);
        System.out.println("times : "+ Arrays.toString(times));
        int[] busS = new int[n];

        int baseT = 540 ; // 540 = 9*60

        for(int i = 0 ; i < n ;i++) {
            busS[i] = baseT + i*(t);
        }

        System.out.println("Bus S :"+Arrays.toString(busS));

        String answer = "";
        int currPindex = 0 ;

        boolean rideOnBTime = false;
        boolean rideOnLast = false;

        for(int b = 0 ; b < busS.length;b++) {
            int currB = busS[b] ;
            int left = m;
            int too = currPindex + m ;
            for(int p = currPindex ;p < too;p++) {
                if(p>times.length-1) continue;
                // bus time
                if(times[p] <= currB) {
                    currPindex++;
                    left--;
                }
            }
            if(b == busS.length-1) {
                if(left > 0){
                    rideOnBTime = true;
                }else{
                    rideOnLast = true;
                }
            }
        }

        int ah =0 ;
        int am = 0;
        int time = 0;
        if(rideOnBTime){
            time = busS[busS.length-1];
        }
        if(rideOnLast){
            time = times[currPindex - 1];
        }
        ah = time / 60;
        am = time % 60 ;
        // 1minture fast to ride
        if(rideOnLast){
            if(am == 0){
                ah--;
                am = 59;
            }else {
                am--;
            }

        }
        String reh ="";
        String rem ="";

        if(ah < 10){
            reh ="0"+ah;
        }else {
            reh = Integer.toString(ah);
        }

        if(am < 10){
            rem ="0"+am;
        }else {
            rem = Integer.toString(am);
        }
        answer = reh+":"+rem;
        return answer;
    }


}
//////  버스가 540 일때 , 최대 인원수는 2명인 경우 ,  540 보다 작은 480 만 탄다.