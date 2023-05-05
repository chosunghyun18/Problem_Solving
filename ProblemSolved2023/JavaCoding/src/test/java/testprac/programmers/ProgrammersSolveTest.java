package testprac.programmers;

import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ProgrammersSolveTest {

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
    @Test
    void kakao19Final_test() {
            //given
            int N = 5;
            int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

            Arrays.sort(stages);   // Arrays.stream(stages).forEach(System.out::println);

            System.out.println(Arrays.stream(stages)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(" ")));

            Map<Integer,Integer> clearStage = new HashMap<>();

            for(int item : stages){
                clearStage.put(item,clearStage.getOrDefault(item,0)+1);
            }

            System.out.println(clearStage);

            double[] ratio = new double[N+1];
            int counted = 0;
            for(int i = 1 ; i <N+1 ; i++) {
                int item = clearStage.getOrDefault(i,0);
                if(item != 0 && (stages.length - counted) != 0 ){
                    ratio[i] = (double) item /(stages.length - counted);
                    counted += item;
                }
            }
            System.out.println(Arrays.stream(ratio)
                    .mapToObj(Double::toString)
                    .collect(Collectors.joining(" ")));

            List<Integer> anar = new ArrayList();
            for(int i = 1 ;i<N+1;i++){
                anar.add(i);
            }

            Collections.sort(anar,(a,b)->Double.compare(ratio[b],ratio[a]));

            int[] answer = anar.stream().mapToInt(i->i).toArray();

            System.out.println(answer);
    }
    @Test
    void kakao18Blind_dart_test(){
        String dartResult = "1D2S#10S";

        String[] re = dartResult.split("");

        List<String> dartItem = new ArrayList(Arrays.stream(re)
                .collect(Collectors.toList())
        );
        // 1 ,0 -> 10 으로 처리
        for(int i = 0; i < dartItem.size(); i++){
            if (dartItem.get(i).equals("0")) {
                if(i != 0 ){
                    if(dartItem.get(i-1).equals("1")) {
                        dartItem.set(i-1,"10");
                        dartItem.remove(i);
                    }
                }
            }
        }
        // System.out.println(dartItem);

        int[] ans = new int[3];
        int index = 0 ;
        for(int i = 0; i < dartItem.size(); i++){
            if( dartItem.get(i).equals("S"))
            {
                ans[index] = Integer.parseInt(dartItem.get(i-1));
                index += 1;
            }
            else if(dartItem.get(i).equals("D")) {
                ans[index] = (int)Math.pow(Integer.parseInt(dartItem.get(i-1)),2);
                index += 1;
            }
            else if(dartItem.get(i).equals("T")) {
                ans[index] =  (int)Math.pow(Integer.parseInt(dartItem.get(i-1)),3);
                index += 1;
            }
        }

        index = 0;
        for(int i = 0; i < dartItem.size(); i++){
            if( dartItem.get(i).equals("*"))
            {
                if(i==2)
                {
                    ans[0] = ans[0]*2;
                }else if(i==dartItem.size()-1){
                    ans[2] = ans[2]*2;
                    ans[1] = ans[1]*2;
                }else{
                    ans[0] = ans[0]*2;
                    ans[1] = ans[1]*2;
                }
            }else if( dartItem.get(i).equals("#"))
            {
                if(i==2){
                    ans[0] = ans[0]*(-1);
                }else if(i == dartItem.size()-1){
                    ans[2] = ans[2]*(-1);
                }else{
                    ans[1] = ans[1]*(-1);
                }
            }
        }

        // System.out.println(Arrays.stream(ans)
        //                    .boxed()
        //                     .collect(Collectors.toList()));
        int answer = 0;
        for(int item : ans){
            answer += item ;
        }

        Assertions.assertThat(answer).isEqualTo(9);
    }
}

