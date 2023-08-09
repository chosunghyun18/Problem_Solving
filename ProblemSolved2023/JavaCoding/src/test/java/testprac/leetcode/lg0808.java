package testprac.leetcode;


import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class lg0808 {
    @Test
    void test(){
        String[] str1 = {"eat","tea","tan","ate","nat","bat"} ;
        String[] str2 = {""} ;
        String[] str3 = {"a"} ;
        System.out.println(groupAnagrams(str1));
        System.out.println(groupAnagrams(str2));
        System.out.println(groupAnagrams(str3));
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int size = Arrays.stream(nums).
                distinct().
                boxed().
                collect(Collectors.toList()).size();
        return size == nums.length;
    }
    public List<List<String>> groupAnagramsBrutal(String[] strs) {

        if(strs.length == 1) return Collections.singletonList(Collections.singletonList(strs[0]));

        List<List<String>> ans = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        tmp.add(strs[0]);
        ans.add(tmp);

        for(int i = 1 ; i  < strs.length;i++ ) {
            boolean find = false;
            tmp = new ArrayList<>();
            for(int j  = 0 ; j< ans.size();j++) {
                String check = ans.get(j).get(0);
                if(isAnagram(check,strs[i])){
                    ans.get(j).add(strs[i]);
                    find = true;
                    break;
                }
            }
            if(!find)
            {
                tmp.add(strs[i]);
                ans.add(tmp);
            }
        }
        return ans ;
    }
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        char[] sarr = s.toCharArray() ;
        char[] tarr = t.toCharArray() ;

        Arrays.sort(sarr);
        Arrays.sort(tarr);

        return Arrays.equals(sarr,tarr);

    }
    @Test
    void test_topK() {
        int[]  n = {1,1,1,2,2,3};
        int k = 2 ;
        System.out.println(Arrays.toString(topKFrequent(n,k)));
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] re = new int[k];
        Map<Integer,Integer>  m = new HashMap<>();
        for(int item : nums) {
            m.put(item,m.getOrDefault(item,0)+1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> item :m.entrySet()) {
            List<Integer> list = Arrays.asList(item.getValue(),item.getKey());
            ans.add(list);
        }

        ans.sort((a,b) ->b.get(0) - a.get(0) );

        for(int i =0 ; i < k ;i++){
            re[i] = ans.get(i).get(1);
        }
        return re;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>();
    }
    @Test
    public void void_product_self(){
        int[] n = {-1,1,0,-3,3} ;
        System.out.println(Arrays.toString(productExceptSelf(n)));
    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length ;
        List<Integer> index  = new ArrayList<>();
        int pro = 1 ;
        for(int i = 0 ; i <  n ; i++) {
            if(nums[i] == 0 ) index.add(i) ;
            if(nums[i] != 0) pro *= nums[i] ;
        }

        if(index.size()  > 1) {
            return new int[n] ;
        }

        if(index.size() == 1) {
            Arrays.fill(nums,0);
            nums[index.get(0)] = pro;
            return nums ;
        }

        for(int i = 0 ; i <  n ; i++) {
            nums[i] = pro / nums[i] ;
        }
        return nums ;

    }

    @Test
    public void sudoku_Test() {
        char[][] b = {
            {'.','.','.','.','.','.','5','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'9','3','.','.','2','.','4','.','.'},
            {'.','.','7','.','.','.','3','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','3','4','.','.','.','.'},
            {'.','.','.','.','.','3','.','.','.'},
            {'.','.','.','.','.','5','2','.','.'}
        };
        System.out.println(isValidSudoku(b));

    }

    public boolean isValidSudoku(char[][] board) {
        // loop  row check
        for(char[] line :board) {
            if(isRowDuplicate(line)) return false;
        }
        // loop column check

        for(int i = 0 ; i < 9 ;i++) {
            Map<Character , Integer> map = new HashMap<>();
            for(int j = 0 ; j < 9 ; j++) {
                char item = board[j][i];
                if(item== '.') continue;
                if(map.containsKey(item)) {
                    return false;
                }
                else {
                    map.put(item,0);
                }
            }
        }

        // loop  3 boxed check
        if(isBoxDuplicate(board)) return false;
        return true;
    }

    private boolean isBoxDuplicate(char[][] board) {
        for (int s = 0; s < 7; s = s + 3) {
            int count = 0 ;
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < 9 ; j++) {
                for (int i = s; i < s + 3; i++) {
                    count++;
                    if(count > 9) {
                        count = 1;
                        map = new HashMap<>();
                    }
                    char item = board[j][i];
                    if (item == '.')
                        continue;
                    if (map.containsKey(item))
                        return true;
                    map.put(item, 0);
                }
            }
        }
        return false;
    }

    public boolean isRowDuplicate(char[] list){
        Map<Character , Integer> map = new HashMap<>();
        for(char item : list) {
            if(item == '.') continue;
            if(map.containsKey(item)) {
                return true;
            }
            else {
                map.put(item,0);
            }
        }
        return false;
    }
    @Test
    public void test_longet(){
        int[] nums =    {-6,-1,-1,9,-8,-6,-6,4,4,-3,-8,-1};
        longestConsecutive(nums);
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        List<Integer> arr = Arrays.stream(nums).
                distinct().
                boxed().
                collect(Collectors.toList());
        int maxC = 0 ;
        int co = 0 ;
        if(nums.length == 0 ) return 0 ;
        if(nums.length == 1 || arr.size() ==1 ) return 1 ;


        int past = nums[0] ;
        for(int item : arr){
            past++;
            if(item == past) {
                co++ ;
                maxC = Math.max(co,maxC);
            }else{
                co = 1;
            }
            past = item;
        }
        if(maxC == 0) return 1;
        return maxC ;
    }
}



























