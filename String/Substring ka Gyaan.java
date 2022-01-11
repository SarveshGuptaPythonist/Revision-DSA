import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = "abcd";
        
        System.out.println(str.substring(1)); // bcd
        System.out.println(str.substring(2)); // cd
        System.out.println(str.substring(3)); // d
        System.out.println(str.substring(0, 0) + str.substring(1)); // bcd
        System.out.println(str.substring(0, 1) + str.substring(2)); // acd
        System.out.println(str.substring(0, 2) + str.substring(3)); // abd
        System.out.println(str.substring(0, 3) + str.substring(4)); // abc
        // starting to ending - 1
        // if param is (4) or length of string it dont print anything
    }
}
