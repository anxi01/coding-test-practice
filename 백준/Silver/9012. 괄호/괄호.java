import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      System.out.println(isValidVPS(s));
    }
  }

  static String isValidVPS(String s) {
    ArrayDeque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push('(');
      } else {
        if (stack.isEmpty() || stack.pop() == s.charAt(i)) {
          return "NO";
        }
      }
    }

    if (stack.isEmpty()) {
      return "YES";
    } else {
      return "NO";
    }
  }
}