import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n + 1];

    // dp[1] = 1, 1^2
    // dp[2] = 2, 1^2 + 1^2
    // dp[3] = 3, 1^2 + 1^2 + 1^2
    // dp[4] = 1, 2^2
    // dp[5] = 2, 2^2 + 1^2
    // dp[6] = 3, 2^2 + 1^2 + 1^2

    for (int i = 1; i <= n; i++) {
      dp[i] = i; // dp의 최댓값 : i => dp[10] = 1^2 * 10 (최악의 경우 : 제곱수 1)

      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }
    System.out.println(dp[n]);
  }
}
