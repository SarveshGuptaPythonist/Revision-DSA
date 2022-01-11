import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        String output = "";
        printSS(input, output);
    }

    public static void printSS(String input, String output) {
        // base case
        if(input.equals("")){
            System.out.println(output);
            return;
        }
        // main case
        
        char ch = input.charAt(0);
        printSS(input.substring(1), output+ch);
        printSS(input.substring(1), output);
    }

}
/*
Sample Input
yvTA

Sample Output
yvTA
yvT
yvA
yv
yTA
yT
yA
y
vTA
vT
vA
v
TA
T
A


Tree on Page 1
*/
