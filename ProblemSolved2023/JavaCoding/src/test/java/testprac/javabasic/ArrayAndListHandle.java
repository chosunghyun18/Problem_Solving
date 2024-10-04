package testprac.javabasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class ArrayAndListHandle {
    @Test
    public void arrayToList(){
        int [] ans = {1,4,2,3};
        List<Integer> anser = new ArrayList<>();
        for (int item : ans){
            anser.add(item);
        }
        anser.sort((a,b)->b-a);
        anser.stream().max().orElseThrow();

        System.out.println(anser);
    }
    @Test
    public void arrayToListVersion2(){
        int [] ans = {1,2,3};
        List<Integer> anser = new ArrayList<>(Arrays.stream(ans).boxed().collect(Collectors.toList()));
        for (int item : ans){
            anser.add(item);
        }
    }
}
