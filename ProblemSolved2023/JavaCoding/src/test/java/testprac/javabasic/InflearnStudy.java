package testprac.javabasic;

import java.math.BigInteger;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InflearnStudy {

    @Test
    void data_print_test1(){
        // 기본 출력
        System.out.println("Hello World!");
        // 문자열 , 숫자 , 불리언
        System.out.println(12);
        System.out.println(1_000);
        int given = 1_000+12 ;

        int expect = 1_012;
        Assertions.assertThat(given).isEqualTo(expect);


        double score = 90.5;
        Double score2 = 90.5;

        char grade = 'A';  // "A" 불가
        Character grade2 = 'A';
        System.out.println(score+grade);

        boolean pass = true;
        Boolean pass1 = true;
        System.out.println(pass1);

        float fex = 3.141592F;
        System.out.println(fex);


        given = 2_147_483_647 ; // max int size
        System.out.println(given);

        long lex = 9_223_372_036_854_775_807L; // max long size
        System.out.println("lex : "+ lex);
        // int ,long, float, double,char,String,boolean
        /*
         Point 1
         */
        BigInteger bigInteger = new BigInteger("31415921234567800090000000000000"); // 무한으로 입력 가능 under score 사용 불가
        System.out.println("BigInteger : "+bigInteger);

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
    void data_print_test2(){
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
    void typeCasting_test(){
        int score = 93 ;
        System.out.println(score);
        System.out.println((double)score);
        System.out.println((float)score);

        float score_f = 93.0f;
        Assertions.assertThat(score).isEqualTo((int)score_f);

        double score_d = 93.0d;
        Assertions.assertThat(score).isEqualTo((int)score_d);

        double dex = 3.141592123456789d;
        double dex1 = 3.141592123456789d;
        double dex2 = 3.141592123456789;

        Assertions.assertThat(dex).isEqualTo(dex1);
        Assertions.assertThat(dex).isEqualTo(dex2);
        Assertions.assertThat(dex1).isEqualTo(dex2);
    }

}
