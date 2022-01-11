import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        psp(n, "");
    }

    public static void psp(int n, String path) {
        if(n <= 0){
            if(n==0) System.out.println(path);
            return;
        }
        
        psp(n-1, path + "1");
        psp(n-2, path + "2");
        psp(n-3, path + "3");
    }

}
// Tree on page 2
