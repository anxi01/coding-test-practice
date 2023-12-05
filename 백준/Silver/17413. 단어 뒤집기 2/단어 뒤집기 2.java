import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        boolean isOpen = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                isOpen = true;
                // < 앞에 이전까지 stack에 넣어진 값 pop
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == '>') {
                isOpen = false;
                sb.append(s.charAt(i));
            } else if (isOpen) {
                sb.append(s.charAt(i));
            } else if (!isOpen) {
                if (s.charAt(i) == ' ') {
                    // 띄어쓰기 만나면 stack에 넣어진 값 pop
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(s.charAt(i));
                } else stack.push(s.charAt(i));
            }
        }
        // 나머지 값까지 추가해줌
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
