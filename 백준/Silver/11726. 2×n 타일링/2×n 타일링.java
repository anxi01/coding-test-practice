import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. 빈 리스트 만들기 (입력값이 최대 1000이므로 1001개의 크기의 배열을 생성)
        int[] dp = new int[1001];

        // 2. 초기값 설정 -> 직접 구해보면 쉽게 찾을 수 있음.
        dp[1] = 1;
        dp[2] = 2;

        // 3. 점화식 기반 계산값 적용
        for (int index = 3; index < 1001; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
            
            // modulo 연산 하기 (여기서 연산 안하면 오버플로우 발생)
            dp[index] = dp[index] % 10007;
        }

        // 4. 특정 입력값에 따른 계산값을 리스트에서 추출
        System.out.println(dp[n]);
    }
}
