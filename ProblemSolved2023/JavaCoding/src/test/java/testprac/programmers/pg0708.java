package testprac.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class pg0708 {


    @Test
    void sol1(){
        String s = "1451232125";
        int n = 2 ;  // 12 또는 21 부분 문자열
        solution1(s,n); // expect 21
    }
    @Test
    void sol11(){
        String s = "313253123";
        int n = 3 ;  // 12 또는 21 부분 문자열
        solution1(s,n); // expect 312
    }
    @Test
    void sol12(){
        String s = "12412415";
        int n = 4 ;  // 12 또는 21 부분 문자열
        solution1(s,n); // expect -1
    }
    public int solution1(String s, int N) {
        String[] digit = s.split("");
        List<Integer> answerCandi = new ArrayList<>();
        for (int i = 0; i < digit.length; i++) {
            boolean[] check = new boolean[N];
            if (Integer.parseInt(digit[i]) > N) continue;
            String tmp = digit[i];
            check[Integer.parseInt(digit[i]) - 1] = true;
            for (int j = i + 1; j < digit.length; j++) {
                if (Integer.parseInt(digit[j]) -1 > N -1) {
                    break;
                }
                if (check[Integer.parseInt(digit[j]) - 1]) {
                    break;
                } else {
                    if (Integer.parseInt(digit[j]) > N) {
                        break;
                    }

                    check[Integer.parseInt(digit[j]) - 1] = true;
                    tmp += digit[j];
                }
            }

            if ( (!tmp.equals("") && tmp.length() == N ))
                answerCandi.add(Integer.parseInt(tmp));
        }

        if (answerCandi.isEmpty())
            return -1;
        int max = Integer.MIN_VALUE;
        for (int num : answerCandi) {
            if (num > max)
                max = num;
        }
        return max;
    }
//    public int solution(String s, int N) {
//        List<Integer> answerCandi = new ArrayList<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            int currentDigit = Character.getNumericValue(s.charAt(i));
//
//            if (currentDigit > N) {
//                continue;
//            }
//
//            StringBuilder tmp = new StringBuilder(String.valueOf(currentDigit));
//            boolean[] check = new boolean[N];
//            check[currentDigit - 1] = true;
//
//            for (int j = i + 1; j < s.length(); j++) {
//                int nextDigit = Character.getNumericValue(s.charAt(j));
//
//                if (nextDigit - 1 > N - 1 || check[nextDigit - 1]) {
//                    break;
//                }
//
//                if (nextDigit > N) {
//                    break;
//                }
//
//                check[nextDigit - 1] = true;
//                tmp.append(nextDigit);
//            }
//
//            if (tmp.length() == N) {
//                answerCandi.add(Integer.parseInt(tmp.toString()));
//            }
//        }
//
//        if (answerCandi.isEmpty()) {
//            return -1;
//        }
//
//        return Collections.max(answerCandi);
//    }



    @Test
    void sol2(){
        int [][] relation=  { {1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5} }; // 1,2 now each other
        int tar = 2 ;
        int limit = 3 ;
        solution2(relation,tar,limit);
    }
    public int solution2(int[][] relationships, int target, int limit) {
        Arrays.sort(relationships, Comparator.comparingInt(a -> a[0]));
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);

        int oldFriends = 0; // node which was depth is 1 from target
        int newFriends = 0; // node whih was depth is over 1
        int depth = 0;

        while (!queue.isEmpty() && depth <= limit) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int currentFriend = queue.poll();

                if (depth == 1) {
                    oldFriends++;
                } else if (depth > 1) {
                    newFriends++;
                }

                for (int[] relation : relationships) {
                    int next = 0 ;
                    if(relation[0] == currentFriend){
                        next = relation[1];
                    } else if (relation[1] == currentFriend) {
                        next = relation[0];
                    }
                    if(next == 0) continue;
                    if (!visited.contains(next))
                    {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            depth++;
        }

        return (oldFriends * 5) + (newFriends * 10) + newFriends;
    }

    @Test
    void sol3_0(){
        String[] mN ={"토스커피사일로 베이커리", "토스커피사일", "토스커피사일로 베이커", "토스커피사일로 베이", "토스커피사일로&베이커리"};
        String[] answ = {"토스커피사일로&베이커리"};
        solution(mN);
    }
    @Test
    void sol3_1(){
        String[] mN = {"비바리퍼블리", "토스커피사일로 베이커리", "비바리퍼블리카 식당", "토스커피사일", "토스커피사일로 베이커", "비바리퍼블리카식", "토스커피사일로 베이", "토스커피사일로&베이커리"};
        String[] answ ={"토스커피사일로&베이커리", "비바리퍼블리카 식당"};
        solution(mN);
    }

    public String[] solution(String[] merchantNames) {
        Arrays.sort(merchantNames);

        String tmpCheck = merchantNames[0].substring(0, 1);
        List<List<String>> names = new ArrayList<>();
        List<String> tmpName = new ArrayList<>();
        tmpName.add(merchantNames[0]);
        names.add(tmpName);

        int count = 0 ;
        for (int i = 1; i < merchantNames.length; i++) {
            String item = merchantNames[i];
            String firstChar = item.substring(0, 1);

            if (firstChar.equals(tmpCheck)) {
                names.get(count).add(item);
            } else {
                count++;
                tmpName = new ArrayList<>();
                tmpName.add(item);
                names.add(tmpName);
                tmpCheck = firstChar;
            }
        }

        List<String> answerList = new ArrayList<>();
        int maxLength = 0;
        for(List<String> merch : names) {
            List<String> tmpList = new ArrayList<>();
            for (String name : merch) {
                String cleanName = name.replaceAll("[^a-zA-Zㄱ-ㅎ가-힣 ]", "");
                int length = cleanName.replace(" ", "").length();
                if (length > maxLength) {
                    maxLength = length;
                    tmpList.clear();
                    tmpList.add(name);
                } else if (length == maxLength) {
                    tmpList.add(name);
                }
            }
            answerList.add(tmpList.toString());
        }

        String[] answer = new String[answerList.size()];
        int index = 0;

        for (String candidate : answerList) {
            if (candidate.contains(",")) {
                String[] checked = candidate.split(",");
                int checkSize = 0;
                for (String nm : checked) {
                    nm = nm.replace("[", "").replace("]", "");
                    if (nm.replace(" ", "").length() > checkSize) {
                        answer[index] = nm.trim();
                        checkSize = nm.replace(" ", "").length();
                    }
                }
                index++;
            } else {
                answer[index] = candidate.replace("[", "").replace("]", "").trim();
                index++;
            }
        }
        return answer;
    }

    @Test
    void sol4(){

    }



    @Test
    void sol5(){

    }


    @Test
    void sol6(){

    }



    @Test
    void sol7(){

    }

}
