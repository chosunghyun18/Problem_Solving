package testprac.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testprac.javacoding.tool.Parser;

public class Programmers0630 {

    private Parser pr;

    public Programmers0630() {
        pr = new Parser();
    }

    @Test
    void sol0() {

        String feesGiven = "[180, 5000, 10, 600]";
        String recordsGiven =
            "[05:34 5961 IN, 06:00 0000 IN, 06:34 0000 OUT, 07:59 5961 OUT, 07:59 0148 IN, 18:59 0000 IN,"
                + " 19:09 0148 OUT, 22:59 5961 IN, 23:00 5961 OUT]";

        int[] fees = pr.parseIntegerList(feesGiven);

        recordsGiven = recordsGiven.replace("[", " ").replace("]", ",");
        String[] recordsSplit = recordsGiven.split(",");

        String answerGiven = "[14600, 34400, 5000]";

        int[] ans = pr.parseIntegerList(answerGiven);
        for(int i = 0 ; i< recordsSplit.length;i++) {
            recordsSplit[i] = recordsSplit[i].trim();
        }
        assertThat(ans).containsExactly(solution0(fees, recordsSplit));
    }

    public int[] solution0(int[] fees, String[] records) {
        System.out.println(Arrays.toString(records));
        // [ 05:34 5961 IN,  06:00 0000 IN,  06:34 0000 OUT,  07:59 5961 OUT,  07:59 0148 IN,  18:59 0000 IN,  19:09 0148 OUT,  22:59 5961 IN,  23:00 5961 OUT]

        // carNumber : time ,state , stackTime
        TreeMap<Integer,List<String>> carRecord = new TreeMap<>();
        for(String record : records) {
            String[] info = record.split(" ");
            Integer carNum = Integer.parseInt(info[1]);
            if(!carRecord.containsKey(carNum)) {
                List<String> infoPut = new ArrayList<>();
                infoPut.add(info[0]);
                infoPut.add(info[2]);
                infoPut.add("0");
                carRecord.put(carNum,infoPut);
            }else{
                // info : 05:34 5961 IN
                List<String> recorded = carRecord.get(carNum);
                String time = recorded.get(0);
                String state = recorded.get(1);
                int stackTime = Integer.parseInt(recorded.get(2));
                if(state.equals("IN")) {

                    String gt = info[0];
                    String[] gtl = gt.split(":");
                    int h = Integer.parseInt(gtl[0]);
                    int m = Integer.parseInt(gtl[1]);
                    int givenTime = h*60 + m;

                    String[] tl = time.split(":");
                    h = Integer.parseInt(tl[0]);
                    m = Integer.parseInt(tl[1]);
                    stackTime +=  givenTime - (h*60 + m);

                    List<String> infoPut = new ArrayList<>();
                    infoPut.add(info[0]);
                    infoPut.add(info[2]);
                    infoPut.add(Integer.toString(stackTime));
                    carRecord.put(carNum,infoPut);
                }else{
                    List<String> infoPut = new ArrayList<>();
                    infoPut.add(info[0]);
                    infoPut.add(info[2]);
                    infoPut.add(Integer.toString(stackTime));
                    carRecord.put(carNum,infoPut);
                }
            }
        }
        String time = "23:59";
        String[] tl = time.split(":");
        int h = Integer.parseInt(tl[0]);
        int m = Integer.parseInt(tl[1]);
        int maxTime = (h*60 + m);

        //        TreeMap<Integer,List<String>> carRecord = new TreeMap<>();
        // info  : time , state , valuetime
        // crRecord : keu :info
        for (Integer key : carRecord.keySet()) {
            List<String> info = carRecord.get(key);
            if(info.get(1).equals("IN")){
                List<String> infoPut = new ArrayList<>();
                infoPut.add(info.get(0));
                infoPut.add("OUT");
                int stored = Integer.parseInt(info.get(2));

                String[] gt = info.get(0).split(":");
                int hl = Integer.parseInt(gt[0]);
                int ml = Integer.parseInt(gt[1]);
                int tt = (hl*60 + ml);
                stored += (maxTime - tt);
                infoPut.add(Integer.toString(stored));
                carRecord.put(key,infoPut);
            }
        }

        // carRecord :         // carNumber : time ,state , stackTime
        int[] answer = new int[carRecord.size()];
        int index = 0;
        //fees : [180, 5000, 10, 600] : 기본 분 , 기본 요금 , 단위 분 , 단위 금

        int baseT = fees[0];
        int baseM = fees[1];
        int unitT = fees[2];
        int unitM = fees[3];

        for(List<String> info :carRecord.values()){
            if(Integer.parseInt(info.get(2)) <= baseT) {
                answer[index] = baseM;
            }
            else {
                int tmpT = (Integer.parseInt(info.get(2)) - baseT);
                int t = (int) Math.ceil((double) tmpT / unitT);
                answer[index] = baseM + ((t) * unitM);
            }
            index++;
        }
        return answer;
    }
    //  23-07-02
//    @Test
//    void sol1() {
//        int n = 5 ;
//        String sInfo =  "[2,1,1,1,0,0,0,0,0,0,0]" ;
//        int[] given = pr.parseIntegerList(sInfo);
//
//        String a = "[0,2,2,0,1,0,0,0,0,0,0]";
//        int[] ans = pr.parseIntegerList(a);
//
//        int[] out =  solution1(n,given);
//
//        assertThat(ans).containsExactly(out);
//    }
//    public int[] solution1(int n, int[] info) {
//
//        System.out.println(Arrays.toString(info));
//        List<Integer> answer = new ArrayList<>();
//
//        // case n = 1
//        if(n == 1) {
//            if(info[0] == 1){
//                int[] re = {-1};
//                return re;
//            }
//        }
//
//        return answer;
//    }

    @Test
    void sol1() {

        String sInfo =  "[1, 1, 1, 1, 1]" ;

        int[] numbers = pr.parseIntegerList(sInfo);
        int target = 3;

        int expect = 5 ;
        int result =  solution1(numbers,target);

        Assertions.assertEquals(expect,result);


    }
    @Test
    void sol2() {

        String sInfo =  "[4, 1, 2, 1]" ;

        int[] numbers = pr.parseIntegerList(sInfo);
        int target = 4;

        int expect = 2 ;
        int result =  solution1(numbers,target);

        Assertions.assertEquals(expect,result);


    }

    public int solution1(int[] numbers, int target) {
        int answer = 0;
        int n = numbers.length;
        if(!checkLeft(0,numbers,numbers[0],target)) {
            return 0;
        }
        List<Integer> checkList = new ArrayList<>();
        List<Integer> storeList = new ArrayList<>();
        checkList.add(+numbers[0]);
        checkList.add(-numbers[0]);

        for(int i =1 ; i< n -1 ;i++) {
            for(Integer number: checkList) {
                if(checkLeft(i,numbers,number,target)){
                    storeList.add(number+numbers[i]);
                    storeList.add(number-numbers[i]);
                }
            }

            checkList = new ArrayList<>(storeList);
            storeList.clear();
        }

        for (Integer item : checkList) {
            if (item + numbers[n - 1] == target || item - numbers[n - 1] == target) {
                answer++;
            }
        }
        return answer;
    }

    public boolean checkLeft(int currentDepth, int[] numbers,int current,int target) {

        int leftTotal = 0;
        for(int i  = currentDepth ; i<numbers.length;i++) {
            leftTotal+=numbers[i];
        }

        boolean case1 =  (current + leftTotal)>=target  ;
        boolean case2 =  current - leftTotal >= target  ;

        if(case1 == case2) return false;

        return true;
    }


}





















