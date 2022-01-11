import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printPerm(str, "");
    }

    public static void printPerm(String str, String asf) {
        if(str.equals("")) {
            System.out.println(asf);
            return;
        }
        int idx = 0;
        for(char ch: str.toCharArray()){
            
            printPerm(str.substring(0, idx) + str.substring(idx+1), asf + ch);
            idx++;
        }
    }

}
// str.substring(0, idx) + str.substring(idx+1) -> if idx = 1 -> (0, 1) + (2, n) = ac so in next str goes excluding that character

// Sample Input
// abc
// Sample Output
// abc
// acb
// bac
// bca
// cab
// cba
