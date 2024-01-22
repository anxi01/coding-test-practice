import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      long[] dp = new long[n + 1];

      /* 끝자리가 0이면 뒤에 2개, 끝자리가 1이면 뒤에 1개

      dp[1] = 1; // 1
      dp[2] = 1; // 10
      dp[3] = 2; // 100, 101
      dp[4] = 3; // 1001, 1000, 1010
      dp[5] = 5; // 10010 10000 10001 10100 10101
      
      n = 1일 경우, dp[2]에서 오류가 나기 때문에 아래와 같이 해야함.
      */
      
      dp[1] = 1;

      for (int i = 2; i < dp.length; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
      }

      System.out.println(dp[n]);
    }
}