package testprac.programmers.fall;

import java.util.*;
import org.junit.jupiter.api.Test;

public class SortAll {
    @Test
    public void sort(){
        int[] numbers = {1,2,3,4};
        Integer[] arr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,(a,b) ->{return b-a;});

    }
    @Test
    void sorting_test_for_java_fast() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(5);
        arr.add(1);
        arr.add(5);
        arr.add(18);
        arr.add(8);

        merge_sort(arr);
        tim_sort(arr);
        quick_sort(arr);
        double_quick_sort(arr);
    }

    @Test
    public void quick_sort(List<Integer> arr) {

    }
    private void double_quick_sort(List<Integer> arr) {

    }
    private void tim_sort(List<Integer> arr) {

    }
    private void merge_sort(List<Integer> arr) {
        mergeSort(arr,0,arr.size()-1);
    }

    private void mergeSort(List<Integer> arr, int left, int right) {
        if(left<right) {
            int mid = (left+right) / 2 ;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right  -1 );
            merge(arr,left,mid,right);
        }
    }
    private void merge(List<Integer>arr ,int left,int mid,int right){
        int n1 = mid - left -1 ;
        int n2 = right - mid ;
        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for(int i = 0 ;i< n1;i++) {
            leftArray.add(arr.get(left+i));
        }
        for(int i = 0 ;i< n2;i++) {
            rightArray.add(arr.get(mid+1+i));
        }

        int i = 0  , j = 0 ;
        int k = left ;
        while(i< n1 && j < n2) {
            if(leftArray.get(i) <= rightArray.get(j)){
                arr.set(k,rightArray.get(j));
            }else{
                arr.set(k,leftArray.get(j));
            }
        }

        while ( j < k ){
            i++ ;
             j++ ;
        }
        while ( k < j ){
            k++ ;
            j++ ;
        }
    }

}
























