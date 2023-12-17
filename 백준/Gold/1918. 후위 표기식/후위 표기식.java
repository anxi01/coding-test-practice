import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String exp = br.readLine();
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) >= 'A' && exp.charAt(i) <= 'Z') {
                sb.append(exp.charAt(i));
            } else {
                if (exp.charAt(i) == '(') {
                    stack.push(exp.charAt(i));
                } else if (exp.charAt(i) == ')') {
                    // '(' 나올 때까지 출력
                    while (stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop(); // '(' 연산자 제거
                } else {
                    // 괄호 제외 다른 연산자는 우선순위 비교해서 넣어줌
                    while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(exp.charAt(i))) {
                        sb.append(stack.pop());
                    }
                    stack.push(exp.charAt(i));
                }
            }
        }
        // 스택에 남은 연산자 전부 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
        br.close();
    }

    // 우선순위 메서드
    // stack에 쌓여있는 연산자와 현재 찍힌 연산자의 우선순위를 비교한다.
    public static int precedence(char op) {
        if (op == '*' || op == '/') {
            return 2;
        } else if (op == '+' || op == '-') {
            return 1;
        }
        return 0;
    }
}
