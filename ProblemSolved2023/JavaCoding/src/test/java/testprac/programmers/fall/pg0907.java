package testprac.programmers.fall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class pg0907 {
    @Test
    public void arr_test() {
        int[] a ={1,2,3,4};
        List<Integer> arr = new ArrayList<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        System.out.println(arr);

    }

}
