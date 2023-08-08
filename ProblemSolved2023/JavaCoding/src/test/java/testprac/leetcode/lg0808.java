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
}



























