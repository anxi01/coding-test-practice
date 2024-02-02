import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] seq = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      seq[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n];
    int result = 0;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      dp[i] = 1;

      for (int j = 0; j < i; j++) {
        if (seq[j] < seq[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      result = Math.max(result, dp[i]);
    }

    sb.append(result + "\n");

    int value = result;
    Stack<Integer> stack = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
      // 현재 길이와 dp[i]가 같을 경우
      if (value == dp[i]) {
        stack.push(seq[i]);
        value--; // value를 -1 해주고 다시 반복
      }
    }

    while (!stack.isEmpty()) {
      sb.append(stack.pop() + " ");
    }

    System.out.println(sb);
  }
}