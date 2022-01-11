import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int dr = scn.nextInt();
        int dc = scn.nextInt();
        pmp(1, 1, dr, dc, "");
    }

    public static void pmp(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        if(sr > dr || sc > dc) return;
        for(int i = 1; i <= dr; i++){
            pmp(sr, sc+i, dr, dc, psf + "h" + i);
        }
        
        for(int i = 1; i <= dr; i++){
            pmp(sr+i, sc, dr, dc, psf + "v" + i);
        }
        
        for(int i = 1; i <= dr; i++){
            pmp(sr+i, sc+i, dr, dc, psf + "d" + i);
        }
        
    }

}
// tree on page 4
