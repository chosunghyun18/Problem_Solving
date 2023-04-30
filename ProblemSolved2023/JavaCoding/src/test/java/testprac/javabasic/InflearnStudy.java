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

        double dex = 3.141592f;
        double dex2 = 3.141592123456789f;
        System.out.println("dex : " + dex);
        System.out.println("dex2: " + dex2);

        given = 2_147_483_647 ; // max int size
        System.out.println(given);

        long lex = 9_223_372_036_854_775_807L; // max long size
        System.out.println("lex : "+ lex);
        // int ,long, float, double,char,String,boolean

        BigInteger bigInteger = new BigInteger("31415921234567800090000000000000"); // 무한으로 입력 가능 under score 사용 불가
        System.out.println("BigInteger : "+bigInteger);
    }



    @Test
    void data_print_test2(){
        String name = "kris";
        int hour = 15;
        /*
            System.out.println(name + hour+"이다");
            naming sites :
            https://google.github.io/styleguide/javaguide.html
        */


        // 상수 선언
        final String CODE = "1204";
        final String CODE_NUMBER = "KR1";
    }

    @Test
    void 동시성_동일성_비교(){

    }

}
