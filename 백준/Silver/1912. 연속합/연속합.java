import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] seq = new int[n + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      seq[i] = Integer.parseInt(st.nextToken());
    }

    // 누적합
    int[] dp = new int[n + 1];
    int result = seq[1];
    
    for (int i = 1; i <= n; i++) {
      // 이전까지의 합과 현재 원소를 더한 값 vs 현재 수열 값중 큰 값을 선택
      dp[i] = Math.max(dp[i - 1] + seq[i], seq[i]);
      result = Math.max(result, dp[i]);
    }
    System.out.println(result);
  }
}
