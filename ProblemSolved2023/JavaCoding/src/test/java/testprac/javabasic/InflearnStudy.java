package testprac.javabasic;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InflearnStudy {

    @Test
    void data_print_test1() {
        // 기본 출력
        System.out.println("Hello World!");
        // 문자열 , 숫자 , 불리언
        System.out.println(12);
        System.out.println(1_000);
        int given = 1_000 + 12;

        int expect = 1_012;
        Assertions.assertThat(given).isEqualTo(expect);

        double score = 90.5;
        Double score2 = 90.5;

        char grade = 'A';  // "A" 불가
        Character grade2 = 'A';
        System.out.println(score + grade);

        boolean pass = true;
        Boolean pass1 = true;
        System.out.println(pass1);

        float fex = 3.141592F;
        System.out.println(fex);

        given = 2_147_483_647; // max int size
        System.out.println(given);

        long lex = 9_223_372_036_854_775_807L; // max long size
        System.out.println("lex : " + lex);
        // int ,long, float, double,char,String,boolean
        /*
         Point 1
         */
        BigInteger bigInteger = new BigInteger("31415921234567800090000000000000"); // 무한으로 입력 가능 under score 사용 불가
        System.out.println("BigInteger : " + bigInteger);

        /*
         Point 2
         */

        double dex0 = 3.402823500789123456789f;  // 컴파일은 가능  하지만 Wrong compile , os 문제 있을 수도
        double dex1 = 3.402823500789123456789d;  // ok
        double dex2 = 3.402823500789123456789;  // ok

        System.out.println("dex0 +f: " + dex0);
        System.out.println("dex1 +d: " + dex1);
        System.out.println("dex2   : " + dex2);

        float maxFloat = Float.MAX_VALUE;   // 3.4028235e+38f
//        public static final float MAX_VALUE = 0x1.fffffeP+127f; // 3.4028235e+38f
        System.out.println("Max float value: " + maxFloat);

        double f1 = dex1;
        float f2 = maxFloat;

        if (f1 > f2) {
            System.out.println("f1 is greater than f2");
        } else if (f1 < f2) {
            System.out.println("f1 is less than f2");
        } else {
            System.out.println("f1 and f2 are equal");
        }

        float checkFloat0 = 3.40282331f;
        float checkFloat1 = 3.40282331f;
        System.out.println(checkFloat0);
        System.out.println(checkFloat1);
        Assertions.assertThat(checkFloat0).isEqualTo(checkFloat1);
    }

    /*
     Point 3 : check Node class  : final 단일이 항상 상수는 아닌 경우
     */

    // 상수 선언
    static final String CODE = "1204";
    static final String CODE_NUMBER = "KR1";

    @Test
    void data_print_test2() {
        String name = "kris";
        int hour = 15;
        /*
            System.out.println(name + hour+"이다");
            naming sites :
            https://google.github.io/styleguide/javaguide.html
        */

        final String CODE = "1204"; // NODE class

        final int koreanCode = 1204;

    }

    @Test
    void typeCasting_test() {
        int score = 93;
        System.out.println(score);
        System.out.println((double) score);
        System.out.println((float) score);

        float score_f = 93.0f;
        Assertions.assertThat(score).isEqualTo((int) score_f);

        double score_d = 93.0d;
        Assertions.assertThat(score).isEqualTo((int) score_d);

        double dex = 3.141592123456789d;
        double dex1 = 3.141592123456789d;
        double dex2 = 3.141592123456789;

        Assertions.assertThat(dex).isEqualTo(dex1);
        Assertions.assertThat(dex).isEqualTo(dex2);
        Assertions.assertThat(dex1).isEqualTo(dex2);
    }

    @Test
    void operator_test() {
        System.out.println(5.0 / 2);

        int expect = 2;
        Assertions.assertThat(expect).isEqualTo(5 / 2);

        System.out.println(expect++); // out : 2
        System.out.println(expect);  // out : 3
    }

    @Test
    void operation_string() {
        String s = "aa bad";
        String expect = "AA BAD";
        Assertions.assertThat(expect).isEqualTo(s.toUpperCase());

        String sentence = "apple good";
        boolean expectCheck = true;

        Assertions.assertThat(expectCheck).isEqualTo(sentence.contains("apple"));
        Assertions.assertThat(-1).isEqualTo(sentence.indexOf("banan"));

        System.out.println(s.startsWith("aa"));
        /*
        - startsWith ,endWith , indexOf,lastIndexOf ,contains,, etc

        - String replace(CharSequnce target, CharSequence replacement)

        - String replaceAll(String regex, String replacement)
        */
        String exSentence = "one two three four five six";
        System.out.println("sub1 :" + exSentence.substring(exSentence.indexOf("five")));
        System.out.println("sub2 :" + exSentence.substring(exSentence.indexOf("f")));
        System.out.println("sub3 :" + exSentence.substring(3));

        String ex = "  bob  ";
        System.out.println(ex.trim());
        String ex1 = "bob";
        System.out.println(ex.trim().equals(ex1));
        /*
        String equalsIgnoreCase
         */
    }




    /*
    * Java Study 공유 점
    *  - Switch Vs If else
    *  - 동일성 비교 동등성 비교
    *  - for 문
    * */

    @Test
    void switchVsIfElse_Switch_test(){
        String str1 = "C";
        switch (str1) {
            case "A":
                System.out.println(str1);
            case "B":
                System.out.println(str1);
            case "C":
                System.out.println(str1);
        }
    }
    @Test
    void switchVSIfElse_If_else_test(){
        String str1 = "C";
        if ("A".equals(str1)) {
            System.out.println(str1);
        } else if ("B".equals(str1))
        {
            System.out.println(str1);
        } else if ("C".equals(str1)) {
            System.out.println(str1);
        }


        // IF 문의 CPU branch prediction  , 분기 예측의 성능을 고려해야한다
    }


    @Test
    void compare_string() {
        //2.
        // 동일성 비교 동등성 비교
        String str1 ="ABC";
        String str2 ="ABC";

        System.out.println("str1 hashcode: " + str1.hashCode());
        System.out.println("str2 hashcode: " + str2.hashCode());

        if (str1.hashCode() == str2.hashCode()) {
            System.out.println("Hash codes are the same");
            if (str1.equals(str2)) {
                System.out.println("Strings are equal");
            } else {
                System.out.println("Strings are not equal");
            }
        } else {
            System.out.println("Hash codes are not the same");
        }


    }
    @Test
    void SimpleFor(){
        //3 for 문

        List<Integer> arrList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        // Enhanced For
        for (Integer item : arrList){
            System.out.println(item);
        }
        // Stream For
        arrList.stream().map(Object::toString).forEach(System.out::println);
    }

    @Test
    void SimpleArrayList(){
        int[] items = {1,2,3,4};
        List<Integer> arrayList = new ArrayList<>(Arrays.stream(items).boxed().collect(Collectors.toList()));

        int[] intAnswer = arrayList.stream().mapToInt(Integer::intValue).toArray();
        int expect = 1;

        Assertions.assertThat(intAnswer[0]).isEqualTo(expect);
    }

    @Test
    void switchVsIfElse_Switch_Enhanced_test(){
        String str1 = "C";
        switch (str1) {
            case "A":
                System.out.println(str1);
            case "B":
                System.out.println(str1);
            case "C":
                System.out.println(str1);
        }

        switch (str1) {
            case "A" -> System.out.println("this is A"+str1);
            case "B" -> System.out.println("this is B"+str1);
            case "C" -> System.out.println("this is C"+str1);

            // point 1
        } // option shift click 다중 선택  + java version 12 이상
    }
    @Test
    void test_ACII(){
        char r = 'A';
        System.out.println((int)r);

        System.out.println(String.valueOf(r)+1);

        System.out.println(Math.pow(5,3)); // 5*5*5

        // point 2
        MethodOverLoading methodOverLoading1 = new MethodOverLoading();

        MethodOverLoading methodOverLoading2 = new MethodOverLoading("Hello");

        //point 3
        // Shorcut Make Main Method : psvm
    }

}