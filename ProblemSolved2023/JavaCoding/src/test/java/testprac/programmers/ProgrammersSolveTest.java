package testprac.programmers;

import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ProgrammersSolveTest {
    @Test
    void sublist()
    {
//        int[] arr;
//        int[] query;
//        int check = 0 ;
//        List<Integer> giarr = new ArrayList();
//
//        for(int item : arr)
//        {
//            giarr.add(item);
//        }
//        for(int item : query){
//            if(check % 2 == 0){
//                giarr = giarr.subList(0,item+1);
//            }
//            else {
//                giarr = giarr.subList(item ,giarr.size());
//            }
//
//            check += 1 ;
//        }
//
//        int[] answer = new int[giarr.size()];
//        for(int i = 0 ; i < giarr.size();i++){
//            answer[i] = giarr.get(i);
//        }
    }
    @Test
    void checkMap(){
        Map<String, String> idMap = new HashMap<>();
        idMap.put("a","1");
        idMap.put("b","1");
        System.out.println(idMap.get("b"));

    }


    @Test
    void kakao_Blind_2019_OpenChat_Simulation(){
        // coding time 40 m : 더 줄여야함
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        Map<String,String> nickId = new HashMap<>();
        List<List<String>> message  = new ArrayList<>();
        List<String> copiedRecord = new ArrayList<>();

        for(String item : record ){
            copiedRecord.add(item) ;
            String[] tmpm = item.split(" ");
            List<String> col = new ArrayList<>();
            if(tmpm[0].equals("Enter")){
                col.add(tmpm[0]);
                col.add(tmpm[1]);
                message.add(col);
                nickId.put(tmpm[1],tmpm[2]);
            }
            if(tmpm[0].equals("Leave")){
                col.add(tmpm[0]);
                col.add(tmpm[1]);
                message.add(col);
            }
            if(tmpm[0].equals("Change")){
                nickId.put(tmpm[1],tmpm[2]);
            }

        }
        nickId.entrySet().stream().forEach(
                item ->
                {
                    message.stream().filter(msg -> msg.get(1).equals(item.getKey())).forEach(msg -> msg.set(1, item.getValue()));
                }
        );
        List<String> answer = message.stream()
                .map(item -> {
                    if(item.get(0).equals("Enter")){
                        return item.get(1) + "님이 들어왔습니다.";
                    } else {
                        return item.get(1) + "님이 나갔습니다.";
                    }
                })
                .collect(Collectors.toList());
        System.out.println(answer);
    }
    @Test
    void kakao_Blind_2019_fail_Simulation_test(){
        int endLevel = 5;
        int[] stageFail = new int[endLevel+1];
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        Arrays.sort(stages);

        for(int item : stages){
            int count = stageFail[item-1];
            stageFail[item-1] = ++count;  // 기본이 중요함 ,
        }

        for(int item : stageFail){
            System.out.print(item);
            System.out.print(" ");
        }
    }
    class kakao_Blind_2019_fail_Simulation_answer1 {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            int userNum = stages.length;
            int endLevel = N;
            Arrays.sort(stages);
            int[] stageFail = new int[endLevel+1]; //[0,1,2,,,5]
            int index = 0 ;
            for(int item : stages){
                int count = stageFail[item-1];
                stageFail[item-1] = ++count;
            }
            float [] ratio = new float[stageFail.length];
            //userNum
            int counted = 0 ;
            index = 0;
            for(int item : stageFail){
                float input = item*0.1f;
                if(userNum-counted != 0) {
                    ratio[index] = input/(userNum-counted);
                    index++;
                    counted += item ;
                }
                else {
                    ratio[index] = 0;
                    break;
                }
            }

            List<StageLev> arr = new ArrayList();
            for(int i = 0 ; i < endLevel;i++)
            {
                arr.add(new StageLev(i+1,(int)(ratio[i]*100_000_000)));
            }
            Collections.sort(arr,(a,b) -> b.ratio - a.ratio);
            // System.out.println(arr.toString());
            for(int i = 0 ; i < endLevel;i++) {
                answer[i] = arr.get(i).getStage();
            }
            return answer;
        }
    }

    class StageLev {
        public int stage;
        public int ratio;

        public StageLev(int i , int r) {
            this.stage = i;
            this.ratio = r;
        }
        public int getStage(){
            return this.stage;
        }
        @Override
        public String toString(){
            return "(" + stage +":" +ratio+"}";
        }
    }
    class kakao_Blind_2019_fail_Simulation_answer2 {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            int userNum = stages.length;
            int endLevel = N;

            Map<Integer, Integer> stageFail = new HashMap<>();
            for(int item : stages){
                stageFail.put(item, stageFail.getOrDefault(item, 0) + 1);
            }

            float[] ratio = new float[N];
            int counted = 0;
            for(int i = 0; i < N; i++){
                int item = stageFail.getOrDefault(i+1, 0);
                if(userNum-counted != 0 && item != 0){
                    ratio[i] = (float)item/(userNum-counted);
                    counted += item;
                }
            }

            List<Integer> arr = new ArrayList<>();
            for(int i = 0 ; i < endLevel; i++){
                arr.add(i+1);
            }
            Collections.sort(arr, (a, b) -> Float.compare(ratio[b-1], ratio[a-1]));

            for(int i = 0 ; i < endLevel; i++){
                answer[i] = arr.get(i);
            }
            return answer;
        }
    }

}
