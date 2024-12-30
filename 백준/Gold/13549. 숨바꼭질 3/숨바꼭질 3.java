import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 풀이 과정:
 * 1. dist 배열 초기화
 * - dist 배열은 각 위치(0부터 100000)까지 도달하는 최소 시간을 저장합니다.
 * - 초기값을 Integer.MAX_VALUE로 설정하여 아직 방문하지 않은 상태를 표시합니다.
 * 
 * 2. 큐를 이용한 BFS 탐색
 * - ArrayDeque를 사용하여 BFS를 수행하며, queue.addFirst()와 queue.addLast()를 사용해 0-1 BFS를 구현합니다.
 *   - 순간 이동 (now * 2)은 가중치가 0이므로 더 우선적으로 처리해야 하므로 addFirst()를 사용합니다.
 *   - 앞/뒤로 이동 (now + 1, now - 1)은 가중치가 1이므로 뒤쪽에 추가(addLast())하여 처리됩니다.
 * 
 * 3. 조건 검증
 * - 매 이동마다 다음 위치(next)가 0 <= next <= 100000 범위 내에 있는지 확인합니다.
 * - 이미 더 빠른 경로로 방문된 경우(dist[next] > dist[now] 또는 dist[next] > dist[now] + 1)는 큐에 추가하지 않습니다.
 * 
 * 4. 결과 출력
 * BFS가 완료된 후, dist[K]를 출력하여 최소 시간을 확인합니다.
 * 
 * 시간 복잡도 : O(V + E)
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        for (int i = 0; i <= 100000; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        dist[N] = 0;
        queue.add(N);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            // 순간 이동
            if (now * 2 <= 100000 && dist[now * 2] > dist[now]) {
                dist[now * 2] = dist[now];
                queue.addFirst(now * 2);
            }

            // 앞/뒤 이동
            if (now + 1 <= 100000 && dist[now + 1] > dist[now] + 1) {
                dist[now + 1] = dist[now] + 1;
                queue.addLast(now + 1);
            }
            if (now - 1 >= 0 && dist[now - 1] > dist[now] + 1) {
                dist[now - 1] = dist[now] + 1;
                queue.addLast(now - 1);
            }
        }

        System.out.println(dist[K]);
    }
}
