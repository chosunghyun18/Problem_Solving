package testprac.programmers;

import java.util.*;

import org.junit.jupiter.api.Test;

public class pg0826 {

    @Test
    public void three_sum_test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    // find sets of integer list which make sum is  0

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;

        int n = nums.length;
        int c = n - 1;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int a = i;
            int b = a + 1;
            while (c > b) {
                int sum = nums[a] + nums[b] + nums[c];

                if (sum == target) {
                    ans.add(List.of(nums[a], nums[b], nums[c]));
                    c--;
                    b++;
                } else if (sum > target) {
                    c--;
                } else {
                    b++;
                }
            }
        }

        List<List<Integer>> re = new ArrayList<>();
        re.addAll(ans);
        return re;
    }

    // if a or b is 0 return
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Test
    public void coll(){
        System.out.println(1<<1);
    }

    @Test
    public void relation_key_test() {
        String[][] relation =
                {{"100", "ryan", "music", "2"},
                        {"200", "apeach", "math", "2"},
                        {"300", "tube", "computer", "3"},
                        {"400", "con", "computer", "4"},
                        {"500", "muzi", "music", "3"},
                        {"600", "apeach", "music", "2"}};

        Arrays.stream(relation)
                .forEach(i -> {
                    System.out.println(Arrays.toString(i));
                });
        System.out.println("value : " + solution(relation));

    }
    public int solution(String[][] relation) {
        int rowSize = relation.length;
        int colSize = relation[0].length;

        // 가능한 모든 조합 리스트
        List<Set<Integer>> keySets = new ArrayList<>();

        for (int i = 1; i < (1 << colSize); i++) {

            Set<Integer> keySet = new HashSet<>();
            for (int j = 0; j < colSize; j++) {
                if ((i & (1 << j)) > 0) {
                    keySet.add(j);
                }
            }

            // 유일성 체크
            Set<String> tupleSet = new HashSet<>();
            for (int k = 0; k < rowSize; k++) {
                StringBuilder tuple = new StringBuilder();
                for (int col : keySet) {
                    tuple.append(relation[k][col]);
                }
                tupleSet.add(tuple.toString());
            }

            // 최소성 체크: keySets에 있는 모든 키 세트에 대해서 현재 keySet이 최소성을 만족하는지 체크
            if (tupleSet.size() == rowSize) {
                boolean isMinimal = true;
                for (Set<Integer> keys : keySets) {
                    if (keySet.containsAll(keys)) {
                        isMinimal = false;
                        break;
                    }
                }
                if (isMinimal) {
                    keySets.add(keySet);
                }
            }
        }
        return keySets.size();
    }
    List<List<Integer>> anwSets = new ArrayList<>();
    List<List<String>> relMap = new ArrayList<>();
    int row = 0;

//    public int solution(String[][] relation) {
//        row = relation.length;
//        int column = relation[0].length;
//        for (int i = 0; i < column; i++) {
//            List<String> tmp = new ArrayList<>();
//            for (int j = 0; j < row; j++) {
//                tmp.add(relation[j][i]);
//            }
//            relMap.add(tmp);
//        }
//        int n = column;
//        for (int r = 1; r <= column; r++) {
//            genCombi(n, r);
//        }
//        int answer = anwSets.size();
//        System.out.println(anwSets);
//        return answer;
//    }
//
//    private void genCombi(int n, int r) {
//        List<Integer> arr = new ArrayList<>();
//        generateCom(n, r, 0, arr);
//    }
//
//    private void generateCom(int n, int r, int start, List<Integer> arr) {
//        if (r == arr.size()) {
//
//            for(List<Integer> sets : anwSets){
//                for(Integer item : sets){
//                    if (arr.contains(item)) return;
//                }
//            }
//
//            List<Set<String>> tmparr = new ArrayList<>();
//            for (int i = 0; i < row; i++) {
//                Set<String> aRow = new TreeSet<>();
//                for (Integer item : arr) {
//                    String element = relMap.get(item).get(i);
//                    aRow.add(element);
//                }
//                if (tmparr.contains(aRow))
//                    return;
//                tmparr.add(aRow);
//            }
//
//            if (tmparr.size() == row) {
//                arr.sort((a,b)-> a-b);
//                anwSets.add(new ArrayList<>(arr));
//            }
//            return;
//        }
//        for (int i = start; i < n; i++) {
//            arr.add(i);
//            generateCom(n, r, i + 1, arr);
//            arr.remove(arr.size() - 1);
//        }
//    }

}








