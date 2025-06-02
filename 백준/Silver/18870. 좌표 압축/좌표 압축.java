import java.io.*;
import java.util.*;

/**
 * 랭킹을 매기자!
 * N이 1_000_000이기 때문에 O(N^2)으로 풀면 시간 초과
 * Map을 사용하자 -> containsKey()는 O(1)
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 원본 배열과 정렬할 배열을 구분
        int[] origin = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        
        // 값이 가장 작은 것부터 랭크를 0으로 부여
        // 중복일 경우, 또 넣지 않음
        int rank = 0;
        for (int e : sorted) {
            if (!map.containsKey(e)) {
                map.put(e, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : origin) {
            int ranking = map.get(key);
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);
    }
}
