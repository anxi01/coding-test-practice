import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split("");
            Stack<String> stack = new Stack<>();

            for(String s : data) {
                if (Objects.equals(s, "(")) {
                    stack.push(s);
                } else if (Objects.equals(s, ")")) {
                    if (stack.isEmpty()) {
                        stack.push(s);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}