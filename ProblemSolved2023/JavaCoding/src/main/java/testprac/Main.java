package testprac;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        testSame();
    }
    private static void testSame(){
        String str1 ="ABC";
//        String str2 ="ABC";
        String str2 ="CAB";

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
}
