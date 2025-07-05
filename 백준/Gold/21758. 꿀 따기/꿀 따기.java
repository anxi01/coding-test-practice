import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] honeys = new int[N + 1];
        int[] honeySum = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int place = Integer.parseInt(st.nextToken());
            honeys[i] = place;
            honeySum[i] = honeySum[i - 1] + place;
        }

        int maxHoney = 0;

        // 첫 번째 경우: 벌(고정) - 꿀통(유동) - 벌(고정)
        for (int i = 2; i < N; i++) {
            int bee1 = honeySum[i] - honeys[1];
            int bee2 = honeySum[N - 1] - honeySum[i - 1];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }

        // 두 번째 경우: 꿀통(고정) - 벌(유동) - 벌(고정)
        for (int i = 2; i < N; i++) {
            int bee1 = honeySum[i] - honeys[i];
            int bee2 = honeySum[N - 1] - honeys[i];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }

        // 세 번째 경우: 벌(고정) - 벌(유동) - 꿀통(고정)
        for (int i = 2; i < N; i++) {
            int bee1 = honeySum[N] - honeys[1] - honeys[i];
            int bee2 = honeySum[N] - honeySum[i];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }

        System.out.println(maxHoney);
    }
}
