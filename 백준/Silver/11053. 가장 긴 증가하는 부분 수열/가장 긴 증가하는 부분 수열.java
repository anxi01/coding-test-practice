import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

      /**
       * seq : 10 20 10 30 20 50
       * dp  : 1  2  1  3  2  4
       */
      for (int i = 0; i < n; i++) {
        dp[i] = 1;

        for (int j = 0; j < i; j++) {
          if (seq[j] < seq[i] && dp[i] < dp[j] + 1) {
            dp[i] = dp[j] + 1;
          }
        }
      }
      Arrays.sort(dp);
      System.out.println(dp[n - 1]);
    }
}