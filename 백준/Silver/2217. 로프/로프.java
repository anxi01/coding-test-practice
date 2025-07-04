/**
 * 1. 로프들을 오름차순 정렬한다.
 * 2. 각 로프를 가장 약한 기준으로 했을 때, 사용할 수 있는 로프 개수를 곱해서 가능한 최대 하중을 계산한다.
 * 3. 그 중 최댓값을 출력한다.
 */

/**
 * case1. 10 20 30
 *
 * 1. 로프 1개 : 30     => 30 로프 사용
 * 2. 로프 2개 : 20 * 2 => 20, 30 로프 사용
 * 3. 로프 3개 : 10 * 3 => 전체 로프 사용
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int maxWeight = 0;
        for (int i = 0; i < N; i++) {
            int currentWeight = ropes[i] * (N - i);
            maxWeight = Math.max(currentWeight, maxWeight);
        }

        System.out.println(maxWeight);
    }
}
