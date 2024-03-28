import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s;
    while ((s = br.readLine()) != null && !s.equals(".")) {
      System.out.println(isValidBalance(s));
    }
  }

  static String isValidBalance(String s) {
    ArrayDeque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[') {
        stack.push(s.charAt(i));
      } else if (s.charAt(i) == ')' || s.charAt(i) == ']') {
        if (stack.isEmpty()) {
          return "no";
        }
        if ((s.charAt(i) == ')' && stack.pop() != '(') || (s.charAt(i) == ']' && stack.pop() != '[')) {
          return "no";
        }
      }
    }
    if (stack.isEmpty()) {
      return "yes";
    } else {
      return "no";
    }
  }
}
