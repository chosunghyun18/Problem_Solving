package testprac.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class pg0829 {
    @Test
    public void mine_test1(){
        int[] picks = {0, 1, 1};
        String[] min =  {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        solution(picks,min);

    }
    @Test
    public void mine_test2(){
        int[] picks = {1, 1, 0};
        String[] min =   {"iron", "iron", "diamond", "iron", "stone", "diamond", "diamond", "diamond"};
        solution(picks,min);

    }
    private String[] minerals;
    public int solution(int[] picks, String[] minerals) {
        //picks : 다 철 돌 , 각 pick 은 광물 5개 + 한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용합니다.
        this.minerals = minerals;
        // minerals :
        int numP = Arrays.stream(picks).sum();
        int numM = minerals.length;

        Map<Integer,Integer> mapRank = new HashMap<>();  // rank , index
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        // q  to strore sumOfScore , map - > index

        int sumOfScore = 0 ;
        int notFinish = 0;
        for(int i = 0 ;i < (numP*5) ; i++) {
            if( i>numM-1 ) break;
            Character mineralH = minerals[i].charAt(0);
            if(mineralH == 'd'){
                sumOfScore+= 25 ;
            } else if (mineralH == 'i') {
                sumOfScore+= 5 ;
            }else{
                sumOfScore+= 1 ;
            }
            if(i != 0 && (i+1) % 5 == 0 || i == numM -1) {
                mapRank.put(sumOfScore,i);
                q.add(sumOfScore);
                sumOfScore = 0 ;
                if(i == numM -1)  notFinish = i;
            }

        }
        // map : (4,125) .,,

        System.out.println(mapRank);
        int answer = 0;

            // mierals = {"diamond", "diamond", "diamond", "iron",  "iron", "diamond", "iron", "stone"};
            //int[] picks = {1, 3, 2};
        int checkIndex = 0;
        for(int s = 0 ; s < numP ;s++){
            if(q.isEmpty()) return answer;
            int score = q.poll();
            int addressIndex = mapRank.get(score);
            if(notFinish > 0&&addressIndex == notFinish ){
                checkIndex = (notFinish / 5)*5;
            }
            else{
                checkIndex = addressIndex - 4 ;
            }

            if(picks[0] > 0){
                answer+=countWithPick(0 ,checkIndex);
                picks[0]--;
            } else if (picks[1] > 0) {
                answer+=countWithPick(1,checkIndex);
                picks[1]--;
            }else {
                answer+=countWithPick(2 ,checkIndex);
                picks[2]--;
            }
        }
        System.out.println(answer);
        return answer;
    }
    public int countWithPick(int pick ,int checkIndex){
        int re = 0;
        for(int i = checkIndex ; i<checkIndex+5 ; i++){
            if(i == minerals.length) return re;
            Character c = minerals[i].charAt(0);
            if(pick == 0) {
                re+=1;
            }
            if(pick == 1) {
                if(c=='d') re+=5;
                if(c!='d') re+=1;
            }
            if(pick == 2) {
                if(c=='d') re+=25;
                if(c=='i') re+=5;
                if(c=='s') re+=1;
            }
        }
        return re;
    }

    @Test
    public void c(){
        solution();
    }




    List<Integer> numbers = new ArrayList();
    public int solution() {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}} ;
        int ans = 0 ;
        List<Integer> numbers = new ArrayList();
        Map<String,Integer> map = new HashMap<>();
        Set<String> keys = new HashSet<>();
        for(String[] cloth : clothes){
            String clothType = cloth[1];
            map.put(clothType,map.getOrDefault(clothType,0)+1);
            keys.add(clothType);
        }
        List<String> keyArr = keys.stream().collect(Collectors.toList());
        System.out.println(map);
        int count = keys.size() -1 ;
        ans = 0 ;
        int multiple  = 1 ;

        if(keys.size() == 1) return map.get(keyArr.get(0));
        else{
            while (count != -1){
                String key = keyArr.get(count);
                numbers.add(map.get(key));
                count--;
            }
        }
        int n = numbers.size() ;
        List<List<Integer>> combinations = new ArrayList<>();
        combine(n,1,new ArrayList<>(),combinations);
        for(List<Integer> combination : combinations) {
            int tmp = 1 ;
            for(Integer item : combination){
                tmp *= numbers.get(item-1);
            }
            ans+=tmp;
        }
        System.out.println(ans);
        return ans;
    }
    public void combine(int n , int start  , List<Integer> current , List<List<Integer>> combinations) {
        if(!current.isEmpty()) {
            combinations.add(new ArrayList<>(current));
        }
        for(int i = start ; i <= n; i++) {
            current.add(i);
            combine(n,i+1,current,combinations);
            current.remove(current.size() -1);
        }
    }
}


















