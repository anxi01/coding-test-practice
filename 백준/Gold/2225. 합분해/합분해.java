import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] dp = new int[n + 1][k + 1];

    /**
     * N = 1, dp[1][1] = 1, dp[1][2] = 2, dp[1][3] = 3
     * N = 2, dp[2][1] = 1, dp[2][2] = 3, dp[2][3] = 6
     * N = 3, dp[3][1] = 1, dp[3][2] = 4, dp[3][3] = 10
     *
     * dp[n][k] = dp[n-1][k] + dp[n][k-1]
     */

    for (int i = 1; i <= n; i++) {
      dp[i][1] = 1;
    }
    for (int i = 1; i <= k; i++) {
      dp[1][i] = i;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= k; j++) {
        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
      }
    }

    System.out.println(dp[n][k]);
  }
}
