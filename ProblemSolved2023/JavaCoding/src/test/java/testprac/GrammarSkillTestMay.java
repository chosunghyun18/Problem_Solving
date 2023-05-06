package testprac;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.Test;


public class GrammarSkillTestMay {
    @Test
    void new_method_test() {

        // ArrayList
        String[] re = {"1", "1", "0", "1", "1"};
        List<String> arr = new ArrayList<>(Arrays.stream(re).collect(Collectors.toList()));

        System.out.println(arr); //   [1, 1, 0, 1, 1]
        arr.add("new");
        arr.set(2, "1");
        arr.remove(3);

        System.out.println(arr); // [1, 1, 1, 1]
        double[] darr = {1.0,2.0,3.0};
        List<Double> darrList = new ArrayList<>(Arrays.stream(darr).mapToObj(Double::valueOf).collect(Collectors.toList()));
        // Double::new 보다 성능이 좋음 cache, memory 차이+ jdk 회서 버전 체크해야함
        System.out.println(darrList);
    }
    @Test
    public int[] kako_blind_report(String[] id_list, String[] report, int k) {

        Map<String, List<String>> reportMap = new HashMap<>();

        for (String reportLine : report) {
            String[] reportData = reportLine.split(" ");
            String reporter = reportData[0];
            String reportedUser = reportData[1];
            List<String> check = reportMap.getOrDefault(reporter,new ArrayList<>());
            if(!check.contains(reportedUser)) {
                check.add(reportedUser);
                reportMap.put(reporter,check);
            }
        }

        Map<String, Integer> reportCount = new HashMap<>();
        for(String name:id_list){
            List<String> check = reportMap.getOrDefault(name,new ArrayList<>());
            for(String item :check){
                Integer count = reportCount.getOrDefault(item,0) + 1;
                reportCount.put(item,count);
            }
        }

        List<String> banded = new ArrayList();
        for(Map.Entry<String,Integer> item : reportCount.entrySet()){
            if (item.getValue() >= k) {
                banded.add(item.getKey());
            }
        }

        int[] answer = new int[id_list.length];


        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            List<String> reported = reportMap.getOrDefault(name, new ArrayList<>());
            int count = 0;
            for (String reporter : reported) {
                if (banded.contains(reporter)) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}