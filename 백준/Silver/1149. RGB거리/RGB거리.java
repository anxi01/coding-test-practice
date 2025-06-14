import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] bgr = new int[N][3]; // B / G / R 배열

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bgr[i][0] = Integer.parseInt(st.nextToken()); // Blue
            bgr[i][1] = Integer.parseInt(st.nextToken()); // Green
            bgr[i][2] = Integer.parseInt(st.nextToken()); // Red
        }

        int[][] dp = new int[N][3];
        dp[0][0] = bgr[0][0]; // Blue 초기화
        dp[0][1] = bgr[0][1]; // Green 초기화
        dp[0][2] = bgr[0][2]; // Red 초기화

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + bgr[i][0]; // 이전 색 (Green/Red) + 현재 색 (Blue)
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + bgr[i][1]; // 이전 색 (Blue/Red) + 현재 색 (Green)
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + bgr[i][2]; // 이전 색 (Blue/Green) + 현재 색 (Red)
        }

        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    }
}
