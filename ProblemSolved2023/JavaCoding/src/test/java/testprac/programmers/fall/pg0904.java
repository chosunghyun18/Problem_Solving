package testprac.programmers.fall;

import java.util.*;

import org.junit.jupiter.api.Test;

public class pg0904 {
        @Test
        void sort_test() {
            int[][] a ={{12,31},{41,13},{21,1},{1,21},{1,22},{22,11},{1,23}};
            // 순서  : 나이 점수
            sort_test(a);
        }
        private void sort_test(int[][] given ) {
            Stack stack = new Stack();
            stack.add(5);
            stack.add(2);
            stack.add(1);
            System.out.println(stack);
            stack.push(2);
            stack.add(0,71);
            stack.add(stack.size(),71);
            System.out.println(stack);
            stack.add(stack.size()-1,74);
            System.out.println(stack);
            System.out.println(stack.peek());

            // 나이 , 점수 순으로 정렬
            Arrays.sort(given,(a,b)->{
                    if(a[0] != b[0]) return a[0] - b[0];
                    return a[1] - b[1];
                }
            );

            System.out.println(Arrays.deepToString(given));
        }
        @Test
        void collection_sort_test() {
            List<List<Integer>> arr = new ArrayList<>();
            arr.add(Arrays.asList(1,2));
            arr.add(Arrays.asList(4,2));
            arr.add(Arrays.asList(12,2));
            arr.add(Arrays.asList(1,24));
            arr.add(Arrays.asList(11,2));
            arr.add(Arrays.asList(1,21));

            System.out.println(arr);

            arr.sort((a,b)->{
                if(a.get(0) == b.get(0)) return b.get(1)  - a.get(1);
                return  a.get(0)- b.get(0);
            });
            System.out.println(arr);
        }
        @Test
        void sorting_test_for_java(){
            List<Integer> arr = new ArrayList<>();
            arr.add(5);
            arr.add(4);
            arr.add(1);
            arr.add(5);
            arr.add(18);
            arr.add(8);
            bubble_sorting_test(arr);    // 인접 한 값들을 비교 , 가장 큰값을  오른쪽에 전부 shift
            selection_sorting_test(arr);  // find  min or max  n ,n-1 ,,, and  change index
            insertion_sorting_test(arr);  // find  값 비교 , 왔던길 , 변경 없으면 멈춤
        }

               /*
                 탐색 하고자 하는 인덱스를 선택 , 왔던 길에 있는 것들 모두 스왑
                */
    private void insertion_sorting_test(List<Integer> arr) {
         ; //  push min in left side  ,,          5 , 4, 1 ,2
        for(int i  = 1 ; i < arr.size() ; i++ ) {
            for(int j = i ; j -1 >-1 ; j--) {
                if(arr.get(j) < arr.get(j-1)){
                    int tmp = arr.get(j-1);
                    arr.set(j-1,arr.get(j));
                    arr.set(j,tmp);
                }else {
                    break;
                }
            }
        }
        System.out.println(arr);
    }
    //   tmp = a .    a = b, b = tmp
    private void selection_sorting_test(List<Integer> arr) {

            for(int j = 0; j <arr.size() -1 ; j++){
                int max = Integer.MIN_VALUE;
                int index = arr.size()+1 ;
                for(int i = 0 ; i < arr.size()-1 - j ; i++ ) {
                        int check = arr.get(0);
                        if(max  < check){
                            max = check;
                            index = i ;
                        }
                }
                arr.set(arr.size()-1 ,arr.get(index));
            }

            System.out.println("selecction : "+arr);
    }

    // tmp , tmp, tmp , 마지막에 큰거 넣기
    public void bubble_sorting_test(List<Integer> arr) {
            System.out.println(arr);
            for(int j = 0 ; j < arr.size() - 1 ; j++){
                for(int i =0 ; i <arr.size()-1 - j;i++){
                    if(arr.get(i) < arr.get(i+1)){
                        int tmp = arr.get(i+1);
                        arr.set((i+1) ,  arr.get(i) ) ;
                        arr.set((i) ,  tmp) ;
                    }
                }
            }
        System.out.println(arr);
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
        quick_sort(arr);
        double_quick_sort(arr);
        merge_sort(arr);
        tim_sorlt(arr);
    }
    private void double_quick_sort(List<Integer> arr) {

    }
    private void quick_sort(List<Integer> arr) {

    }
    private void tim_sorlt(List<Integer> arr) {

    }



    private void merge_sort(List<Integer> arr) {

    }
    @Test
    void brak_test(){  // brak 는 조건문이 있는 loop 를 break 한다.

        for(int i =0 ; i < 5  ; i++){
            System.out.println("this is I: " + i);
            for(int j = 0 ; j < 6 ; j++){
                System.out.println(j);
                if(j == 4) break;
            }
        }
    }

}




























