import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String n = scn.nextLine();
        printEncodings(n, "");
    }

    public static void printEncodings(String str, String output) {
        if(str.equals("")) {
            System.out.println(output);
            return;
        }
        if(str.charAt(0) == '0') return;
        if(str.length() > 0){
            int val = Integer.parseInt(str.substring(0, 1));
            if(val >= 1 && val <= 9)
                printEncodings(str.substring(1), output + (char)(val + 'a' - 1));
        }
        if(str.length() > 1){
            int val = Integer.parseInt(str.substring(0, 2));
            if(val <= 26 && val >= 1)
                printEncodings(str.substring(2), output + (char)(val + 'a' - 1));
        }
    }

}
// tree on page 5
