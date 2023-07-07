package testprac.programmers;



import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;


public class pg0707 {
    @Test
    void sol1(){
//     String given =  "dxccxbbbxcxabaaxaaba" ;
        String given = "a";
      solution1(given);
    }
    public String[] solution1(String myString) {
        //    //13:48 ~ 13:50
        return Arrays.stream(myString.split("x"))
            .filter(str -> !str.isEmpty())
//            .sorted().collect(Collectors.toList()) ;
        .sorted().toArray(String[]::new);
    }
    @Test
    void sol2(){
        int given = 1081 ;
        solution2(given);
    }
    public int solution2(int chicken) {
        //14:24 ~
        if(chicken < 10) return 0 ;
        int service = 0 ;
        int coupon = chicken ;
        while(chicken > 9 ){
            int left = 0 ;
            int serviceTmp = 0 ;
            serviceTmp += chicken / 10 ;
            service += serviceTmp ;
            left = chicken % 10;
            chicken = serviceTmp + left;
        }

        return service;
    }
    @Test
    void sol3(){
        int [] given = {1, 2, 3, 4, 5} ;
        solution3(given);
    }
    public int[] solution3(int[] numbers) {
        return  Arrays.stream(numbers).map(item -> item*2).toArray();
//         for(int i = 0 ; i<numbers.length;i++ ){
//             numbers[i] = numbers[i] *2 ;
//         }
//         return numbers;

    }
    @Test
    void sol4(){
        String [] given = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        solution4(given);
    }
    public int[] solution4(String[] operations) {
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i = 0; i < operations.length; i++){
            String[] commend = operations[i].split(" ");
            int v = Integer.parseInt(commend[1]);
            if(commend[0].equals("I")){
                map.put(v,map.getOrDefault(v,0)+1);
            }else{
                if(map.size() == 0) continue;
                switch (v) {
                    case 1 -> { // delete big
                        int checkMax = map.lastKey();
                        if(map.get(checkMax) > 1){
                            map.put(checkMax,map.get(checkMax)-1);
                        }else{
                            map.remove(checkMax);
                        }
                    }
                    case -1 ->{
                        int checkMin = map.firstKey();
                        if(map.get(checkMin) > 1){
                            map.put(checkMin,map.get(checkMin)-1);
                        }
                        else{
                            map.remove(checkMin);
                        }
                    }

                }
            }
        }

        if(map.size()==0) return new int[]{0,0};
        return new int[]{map.lastKey(),map.firstKey()};
    }
    @Test
    void treemap(){
        TreeMap<Integer,String> map = new TreeMap<Integer,String>(){{//초기값 설정
            put(1, "사과");//값 추가
            put(2, "복숭아");
            put(3, "수박");
        }};

        System.out.println(map); //전체 출력 : {1=사과, 2=복숭아, 3=수박}
        System.out.println(map.get(1));//key값 1의 value얻기 : 사과
        System.out.println(map.firstEntry());//최소 Entry 출력 : 1=사과
        System.out.println(map.firstKey());//최소 Key 출력 : 1
        System.out.println(map.lastEntry());//최대 Entry 출력: 3=수박
        System.out.println(map.lastKey());//최대 Key 출력 : 3
    }
    @Test
    void sol5(){
        int[][] given = {{0, 3}, {1, 9}, {2, 6}};
        solution(given);
    }
    public int solution(int[][] jobs) {

        int sumTime = 0;
        int numTask = jobs.length;  // > 0
        // 요청시간으로 오름차순  , 요청시간이 같다면  처리기간으로 오름차순
        Arrays.sort(jobs, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        int count  = 0 ;
        int jobIdx = 0 ;
        int currentTime = 0;

        PriorityQueue<int[]> queue =  new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        while (count < numTask) {
            while(jobIdx < numTask && jobs[jobIdx][0] <= currentTime){
                queue.add(jobs[jobIdx++]);
            }
            if(queue.isEmpty()){
                currentTime = jobs[jobIdx][0];
            }else{
                int[] tmp = queue.peek();
                sumTime += (tmp[1] + currentTime) - tmp[0];
                currentTime += tmp[1];
                count++;
            }
        }

        return (int) Math.floor(sumTime/numTask);
    }

}


















