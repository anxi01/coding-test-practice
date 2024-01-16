import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        int[] p = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < p.length; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * ex ) i = 2
         * dp[i]
         * = dp[0] + p[2]
         * = dp[1] + p[1]
         */
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
            }
        }

        System.out.println(dp[n]);
    }
}