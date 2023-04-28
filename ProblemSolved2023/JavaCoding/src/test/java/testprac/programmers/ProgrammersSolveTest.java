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

}
