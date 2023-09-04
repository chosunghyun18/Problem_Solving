package testprac.programmers;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class pg0904 {
        @Test
        void sort_test() {
            int[][] a ={{12,31},{41,13},{21,1},{1,21},{1,22},{22,11},{1,23}};
            // 순서  : 나이 점수
            sort_test(a);
        }
        private void sort_test(int[][] given ){
            // 나이 , 점수 순으로 정렬
            Arrays.sort(given,(a,b)->{
                    if(a[0] != b[0]) return a[0] - b[0];
                    return a[1] - b[1];
                }
            );

            System.out.println(Arrays.deepToString(given));
        }


}
