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

            Collections.sort(arr,(a,b)->{
                if(a.get(0) == b.get(0)) return b.get(1)  - a.get(1);
                return  a.get(0)- b.get(0);
            });
            System.out.println(arr);
        }


}




























