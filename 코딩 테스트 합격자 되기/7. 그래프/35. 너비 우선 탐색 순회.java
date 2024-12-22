import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * BFS (넓이우선탐색)
 * 풀이 과정
 * 1. 인접 리스트를 생성한다.
 *   - 인접 리스트는 List의 배열로 생성한다.
 *   - 인접 리스트 초기화는 전체 노드의 개수 + 1로 한다.
 *      - 1 ~ N까지 인덱스로 넣어주기 위해
 *   - 그래프의 출발, 도착 노드를 인접리스트에 넣어준다.
 *
 * 2. 방문 boolean 배열을 만든다. 인접리스트와 마찬가지로 노드 + 1까지 만든다.
 * 3. bfs 메서드를 생성한다. + Queue 사용
 *   - 큐에 시작 노드를 추가한다. + 방문 배열 및 결과 배열에 추가
 *   - 큐가 비어 있지 않다면,
 *      - 큐에 있는 원소 중 가장 먼저 추가된 원소를 추출 및 결과 배열에 추가
 *      - 추출된 원소를 기반으로 인접한 이웃 노드들에 대해
 *        방문하지 않은 경우, 방문 처리 및 큐에 넣기.
 */
public class Main {

    private static ArrayList<Integer>[] adjList;

    private static boolean[] visited;
    private static ArrayList<Integer> result;

    private static int[] solution(int[][] graph, int start, int n) {

        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n + 1];
        result = new ArrayList<>();
        bfs(start);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);

            for(int next : adjList[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
