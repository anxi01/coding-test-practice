import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 시간 복잡도: O(N + M)
 * - 정점의 수: N, 간선의 수: M
 * - BFS는 각 정점과 간선을 한 번씩 처리합니다.
 *
 * 풀이 과정:
 * 1. **입력 처리 및 초기화**
 *    - `N`, `M`, `R`을 입력받아 정점의 수, 간선의 수, 시작 정점을 저장합니다.
 *    - 인접 리스트(`adjList`)를 초기화합니다. 정점 번호가 1부터 시작하므로, 인덱스 0은 사용하지 않습니다.
 *    - 방문 여부를 저장할 배열(`visited`)과 방문 순서를 저장할 배열(`result`)을 초기화합니다.
 *
 * 2. **그래프 생성**
 *    - 간선 정보를 입력받아, 각 정점에 연결된 정점을 인접 리스트 형태로 저장합니다.
 *    - 무방향 그래프이므로 `u -> v`와 `v -> u` 양방향으로 간선을 추가합니다.
 *
 * 3. **정렬**
 *    - BFS 탐색 시 작은 번호의 정점부터 방문하기 위해, 각 정점의 인접 리스트를 오름차순으로 정렬합니다.
 *
 * 4. **BFS 탐색**
 *    - 큐를 사용해 시작 정점 `R`부터 너비 우선 탐색을 수행합니다.
 *    - 방문한 정점의 순서를 `cnt`로 기록하며, 탐색한 정점을 큐에 추가합니다.
 *
 * 5. **결과 출력**
 *    - BFS 탐색 후, 각 정점의 방문 순서를 결과 배열에 저장된 순서대로 출력합니다.
 */
public class Main {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int[] result;
    private static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 방문 배열 및 결과 배열 초기화
        visited = new boolean[N + 1];
        result = new int[N + 1];

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        // BFS 실행
        bfs(R);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            result[now] = cnt++;

            for (int next : adjList[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
