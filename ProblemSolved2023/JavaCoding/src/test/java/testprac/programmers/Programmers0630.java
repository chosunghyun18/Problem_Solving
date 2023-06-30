package testprac.programmers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.ARRAY;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import testprac.javacoding.tool.Parser;

public class Programmers0630 {
    private Parser pr;

    public Programmers0630() {
        pr = new Parser();
    }

    @Test
    void sol0() {


        String feesGiven = "[180, 5000, 10, 600]";
        String recordsGiven = "[05:34 5961 IN, 06:00 0000 IN, 06:34 0000 OUT, 07:59 5961 OUT, 07:59 0148 IN, 18:59 0000 IN,"
            + " 19:09 0148 OUT, 22:59 5961 IN, 23:00 5961 OUT]";

        int[] fees = pr.parseIntegerList(feesGiven);

        recordsGiven=recordsGiven.replace("["," ").replace("]",",");
        String[] recordsSplit = recordsGiven.split(",");

        String answerGiven =  "[14600, 34400, 5000]";

        int[] ans = pr.parseIntegerList(answerGiven);

        assertThat(ans).containsExactly(solution0(fees,recordsSplit));
    }

    public int[] solution0(int[] fees, String[] records) {
        System.out.println(Arrays.toString(records));
        // [ 05:34 5961 IN,  06:00 0000 IN,  06:34 0000 OUT,  07:59 5961 OUT,  07:59 0148 IN,  18:59 0000 IN,  19:09 0148 OUT,  22:59 5961 IN,  23:00 5961 OUT]


        return fees;
    }

}
