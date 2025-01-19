import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    Stack<Integer> stack = new Stack<>();

    int current = 1; // 기대하는 간식 번호

    for (int i = 0; i < N; i++) {
      int now = Integer.parseInt(st.nextToken());

      // 현재 번호가 기대 번호와 같으면 바로 처리
      if (now == current) {
        current++;
      } else {
        stack.push(now); // 스택에 저장
      }

      // 스택에서 처리 가능한 번호를 처리
      while (!stack.isEmpty() && stack.peek() == current) {
        stack.pop();
        current++;
      }
    }

    // 스택이 비어 있으면 모든 간식을 올바르게 처리
    if (stack.isEmpty()) {
      System.out.println("Nice");
    } else {
      System.out.println("Sad");
    }
  }
}
