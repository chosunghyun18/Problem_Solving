package testprac.programmers.fall;

import org.junit.jupiter.api.Test;

public class BinarySearch {
    @Test
    public void binary_Search(){
        int[] nums = {-1,0,3,5,9,12};
        int target = 9 ;
        System.out.println(search_recursion(nums,target));
        System.out.println(search_withLoop(nums,target));
    }
    int[] given ;
    public int search_recursion(int[] nums,int target){
        this.given = nums;
        return find(0,nums.length-1,target);
    }
    public int find(int left , int right,int target) {
        if(left>right) return  -1;
        int mid = (left+right) /2 ;
        if(given[mid] == target) {
            return mid;
        }
        if(given[mid] < target) {
            return find(mid+1,right,target);
        }else {
            return find(left,right-1,target);
        }
    }
    public int search_withLoop(int[] nums,int target){
        int l =0 ;
        int r = nums.length -1 ;
        while (l < r){
            int mid = (l+ r)/2 ;
            if(nums[mid] == target) {
                return mid ;
            }
            else if (nums[mid] > target) {
                r = mid;
            }else{
                l = mid;
            }
        }
        return -1;
    }

}

















