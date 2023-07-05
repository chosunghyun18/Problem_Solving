package testprac.programmers;

import java.util.*;
import java.util.Map;
import org.junit.jupiter.api.Test;
import testprac.javacoding.tool.Parser;

public class pg0704 {
    private Parser pr;
    public pg0704(){
        pr = new Parser();
    }
    @Test
    void test_sol1(){
        String given = "one4seveneight";
        System.out.println(solution1(given));
    }
    public int solution1(String s) {
        int answer = 0;
        String[] dic = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i = 0 ; i < 10 ; i++){
            s= s.replaceAll(dic[i],Integer.toString(i));
        }

        return Integer.parseInt(s);
    }

    void test_cache_sol() {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int cacheSize  = 3 ;
//        System.out.println(solution2(cacheSize,cities));
        System.out.println(sol2_optimal(cacheSize,cities));
    }
    public int sol2_optimal(int cacheSize,String[] cities){
        if (cities.length == 1)
            return 5;

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }

        int operationTime = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        Set<String> cache = new LinkedHashSet<>(cacheSize);
        for (String city : cities) {
            if (cache.contains(city)) {
                operationTime += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                operationTime += 5;
                if (cache.size() >= cacheSize) {
                    Iterator<String> iterator = cache.iterator();
                    iterator.next();
                    iterator.remove();
                }
                cache.add(city);
            }
        }

        return operationTime;
    }

    public int solution2(int cacheSize, String[] cities) {
        if(cities.length == 1) return 5;
        for(int i = 0 ; i<cities.length;i++) {
            cities[i] =cities[i].toUpperCase();
        }


        int operationTime=0 ;
        if(cacheSize == 0 ){
             // no cache and all  cache miss
            return cities.length * 5 ;
        }

        List<String> fastList = new ArrayList<>();
        int check = 0  ;
        for(String city:cities){
            if(fastList.contains(city)){
                check =1 ;
                break;
            }
            else {
                fastList.add(city);
            }
        }

        if(check == 0){
            return cities.length * 5 ;
        }

        // Hash  ?  hash 의 사이즈를 비교
        // name  , recentUsed Info
        // vlaue : recently call point
        Map<String,Integer> cache = new HashMap<>();
        // What  is proper DS  ?  , need  key value , pop out Least Recently Used

        for(String city : cities) {
            if(cache.size() == 0 ){
                operationTime += 5;
                cache.put(city,0);
                continue;
            }
            if(cache.containsKey(city)) {
                operationTime += 1;
                for(Map.Entry<String,Integer> entry : cache.entrySet()) {
                        cache.put(entry.getKey(),entry.getValue()+1);
                    }

                cache.put(city,0);
            }
            else{
                operationTime += 5;
                if(cache.size() >= cacheSize) {
                    int maxValue = cacheSize;
                    String oldKey = "";
                    for(Map.Entry<String,Integer> entry : cache.entrySet()){
                        if (entry.getValue() == maxValue-1) {
                            oldKey =  entry.getKey();
                        }
                        else{
                            cache.put(entry.getKey(),entry.getValue()+1);
                        }
                    }
                    cache.remove(oldKey);
                }
                else{
                    for(Map.Entry<String,Integer> entry : cache.entrySet()){
                        cache.put(entry.getKey(),entry.getValue()+1);
                    }
                }
                cache.put(city,0);
            }
        }

        return  operationTime;
    }
    @Test
    public void test_code_3() {
        int n = 6; // number of computers

        String com = "[[1, 0, 1, 0, 0, 1], [0, 1, 0, 0, 0, 1], [1, 0, 1, 1, 0, 0], [0, 0, 1, 1, 1, 0], [0, 0, 0, 1, 1, 1], [1, 1, 0, 0, 1, 1]]";
        int[][] computers = pr.parseIntegerDoubleList(com);

        System.out.println("result >> " + sol4(n, computers));
    }


    @Test
    public void test_code_2() {
        int n = 3 ; // number of computer

        String com = "[[1, 1, 0], [1, 1, 1], [0, 1, 1]]";
        int[][] computers = pr.parseIntegerDoubleList(com);

        System.out.println("result >> "+sol4(n,computers));
    }

    public int sol4(int n, int[][] computers) {
        boolean[] visited = new boolean[n];

        int count = 0 ;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ;i<n;i++) {
            if(visited[i]) continue;
            q.offer(computers[i]);
            visited[i] = true;
            while (!q.isEmpty()){
                int[] way = q.poll();
                for(int j = 0 ; j < n;j++){
                    if(way[j] == 1 && !visited[j]){
                        q.offer(computers[j]);
                        visited[j] = true;
                    }
                }
            }
            count++;
        }

        return count;
    }
    public String solution(String[] participant, String[] completion) {
        // size part max = 100,000

        // ["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]

        String answer = "Error"; // 완주 s
        Map<String,Integer> participantName = new HashMap<>();
        for(String name : participant) {
            if(!participantName.containsKey(name)){
                participantName.put(name,1);
            }else{
                participantName.put(name,participantName.get(name)+1) ;
            }
        }
        for(String name:completion){
            int checkNumber =  participantName.get(name);
            if(checkNumber > 1) {
                participantName.put(name,checkNumber - 1);
                continue;
            }
            participantName.remove(name);
        }

        answer = String.join("", participantName.keySet());
        return answer;
    }
}


















