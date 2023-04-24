package testprac.javacoding;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
public class GrammerSkillsTest {

    @Test
    public void arrayListTest(){
        ArrayList<Integer> integer1 = new ArrayList<>();
        ArrayList<Integer> integer2 = new ArrayList<>(Arrays.asList());
    }
    @Test
    public void splitTest(){
        int value = 123;
        while(value != 0){
            System.out.println(value%10);
            value /= 10 ;

        }
    }
}
