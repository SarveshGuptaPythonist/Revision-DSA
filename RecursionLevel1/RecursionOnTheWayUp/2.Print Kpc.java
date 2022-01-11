import java.io.*;
import java.util.*;

public class Main {

  static String[] keypad = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String input = scn.nextLine();
    printKPC(input, "");

  }

  public static void printKPC(String input, String output) {
    if (input.equals("")) {
      System.out.println(output);
      return;
    }
    char[] inputchar = keypad[(int)input.charAt(0) - '0'].toCharArray();

    for (char s : inputchar) {
      printKPC(input.substring(1), output + s);
    }
  }
}

// Tree available on page 1 and page 2
