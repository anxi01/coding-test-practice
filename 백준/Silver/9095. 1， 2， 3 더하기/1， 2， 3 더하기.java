import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] dp = new int[11];

        dp[1] = 1; // 1
        dp[2] = 2; // 1 + 1 / 2
        dp[3] = 4; // 1 + 1 + 1 / 1 + 2 / 2 + 1 / 3

        /**
         * dp[4] = 7
         *          dp[1] + 3 : 총 1가지
         *          dp[2] + 2 : 총 2가지
         *          dp[3] + 1 : 총 4가지
         *
         * dp[n] = dp[n-1] + dp[n-2] + dp[n-3];
         */

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}