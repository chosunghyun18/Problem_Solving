package testprac.javacoding;
import org.junit.jupiter.api.Test;
import java.util.*;

public class GrammerSkillsTest {

    @Test
    public void arrayListTest(){
        ArrayList<Integer> givenList = new ArrayList<>(Arrays.asList(3,2,1));
        givenList.stream().forEach(System.out::println);
    }
    @Test
    public void splitTest(){
        int value = 123;
        while(value != 0){
            System.out.println(value%10);
            value /= 10 ;

        }
    }
    @Test
    public void listTest(){
        int[] items = {1,2,3,4};
        ArrayList<Integer> checkList = new ArrayList<>();
        for(int item : items){
           checkList.add(item) ;
        }
        readList(checkList);

        ArrayList<Integer> givenList = new ArrayList<>(Arrays.asList(1,2,3));
        List arrayList = new ArrayList<>(givenList);
        List linkedList = new LinkedList(givenList);

        readList(arrayList);

        System.out.println("");
        readList(linkedList);
    }
    private void readList(List anyList){
        anyList.stream().forEach(System.out::println);
    }
}











