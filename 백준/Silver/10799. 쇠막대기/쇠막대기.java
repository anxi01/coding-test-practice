import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            // 열린 괄호일 경우 stack에 열린 괄호 추가
            if (input.charAt(i) == '(') {
                stack.push('(');
            }
            // 닫힐 경우
            if (input.charAt(i) == ')') {
                stack.pop();
                // 이전 괄호가 열린 괄호면(레이저) 남은 스택 사이즈만큼 더해줌
                if (input.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    // 레이저가 아니면 그냥 결과값만 더해줌
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
