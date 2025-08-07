import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 무게
            int V = Integer.parseInt(st.nextToken()); // 가치

            for (int j = 1; j <= K; j++) {
                if (W <= j) {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],                // 이 물건을 선택하지 않았을 때의 최대 가치
                            dp[i - 1][j - W] + V         // 이 물건을 선택했을 때의 최대 가치
                            // 현재 배낭 용량 j에서 이 물건의 무게 W를 뺀 나머지 공간(j-W)에서 얻을 수 있는 최대 가치(dp[i-1][j-W])에 물건의 가치를 더한 값
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];         // 무게가 초과되어 선택 불가능하므로 이전 물건까지의 최댓값 그대로 사용
                }
            }
        }
        
        System.out.println(dp[N][K]);
    }
}
