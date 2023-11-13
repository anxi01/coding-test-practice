import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 양수 * 양수
        // 음수 * 음수
        // 1이 포함된 경우 곱하기보다 더하기
        // 0이 포함된 경우 양수면 더하기 아니면 곱하기
        int n = sc.nextInt();
        int[] data = new int[n];

        int minusCount = 0;
        for (int i = 0; i < n; i++) {
            int inp = sc.nextInt();
            if (inp <= 0) {
                minusCount++;
            }
            data[i] = inp;
        }
        Arrays.sort(data);

        int res = 0;

        // 음수 * 음수
        for (int i = 1; i < minusCount; i += 2) {
            res += (data[i - 1] * data[i]);
        }
        // 남은 음수(0)의 개수가 1이라면 그냥 더해줌
        if (minusCount % 2 == 1) {
            res += data[minusCount - 1];
        }

        // 양수가 홀수개 일경우 그냥 더하기
        if ((n - minusCount) % 2 == 1) {
            res += data[minusCount];
        }

        // 양수가 짝수개 일경우 두개의 합과 곱중 최댓값을 더함
        for (int i = n - 1; i > minusCount; i -= 2) {
            res += Math.max(data[i] + data[i - 1], data[i] * data[i - 1]);
        }
        System.out.println(res);
    }
}