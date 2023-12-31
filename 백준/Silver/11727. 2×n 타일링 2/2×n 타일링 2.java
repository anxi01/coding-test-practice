import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for (int index = 4; index < 1001; index++) {
            dp[index] = 2 * dp[index - 2] + dp[index - 1];

            dp[index] = dp[index] % 10007;
        }

        System.out.println(dp[n]);
    }
}