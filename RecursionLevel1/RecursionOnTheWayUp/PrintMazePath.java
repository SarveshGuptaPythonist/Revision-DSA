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
    
    pmp(sr, sc + 1, dr, dc, psf + "h");
    pmp(sr + 1, sc, dr, dc, psf + "v");

  }



}
// Tree on page 3
