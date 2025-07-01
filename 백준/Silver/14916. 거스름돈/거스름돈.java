import java.io.*;

public class Main {

    private static final int COIN2 = 2;
    private static final int COIN5 = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // int 최댓값으로 초기화
        int minCount = Integer.MAX_VALUE;

        // 사용할 수 있는 5원 동전의 최대 개수
        int maxCoin5Count = n / COIN5;

        // 5원 동전을 0개부터 최대 개수까지 사용하는 모든 경우 순회
        for (int i = 0; i <= maxCoin5Count; i++) {
            int copyN = n - COIN5 * i; // 5원 동전을 사용한 후 남은 금액

            // 남은 금액이 2원으로 정확히 나누어떨어질 경우만 처리
            if (copyN % COIN2 == 0) {
                int count = i + (copyN / COIN2); // 5원 + 2원 동전 개수의 합
                minCount = Math.min(minCount, count);
            }
        }

        System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
    }
}
