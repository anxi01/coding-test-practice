import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 풀이 과정:
 * 1. 그래프를 인접 리스트로 변환:
 *    - 주어진 간선 정보를 기반으로 각 노드에 연결된 노드와 비용(가중치)을 저장합니다.
 *
 * 2. 초기화:
 *    - 모든 노드의 최단 거리를 `Integer.MAX_VALUE`로 설정합니다.
 *    - 시작 노드의 최단 거리는 0으로 설정합니다.
 *
 * 3. 우선순위 큐를 이용한 다익스트라 알고리즘:
 *    - 우선순위 큐를 사용하여 비용이 가장 작은 노드를 먼저 처리합니다.
 *    - 처리한 노드는 방문 처리(`visited`)하여 중복 작업을 방지합니다.
 *    - 현재 노드에서 연결된 모든 노드를 확인하며, 기존 최단 거리보다 더 작은 비용이 있다면 최단 거리를 갱신하고 큐에 추가합니다.
 *
 * 4. 결과 반환:
 *    - 모든 노드에 대한 최단 거리를 반환합니다.
 *
 * 시간 복잡도:
 * - 그래프를 인접 리스트로 변환하는 데 O(E) (간선의 수)
 * - 다익스트라 알고리즘의 시간 복잡도:
 *   - 우선순위 큐를 사용하는 다익스트라는 O((V + E) * log(V))입니다.
 *   - 여기서 V는 노드의 수, E는 간선의 수입니다.
 *   - 우선순위 큐에서 삽입 및 삭제가 log(V)의 시간 복잡도를 가지며, 모든 간선과 노드를 처리합니다.
 *
 * 최종 시간 복잡도: O((V + E) * log(V))
 */
public class Main {

    private static class Node {
        int destination, cost;

        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    private static int[] solution(int[][] graph, int start, int n) {
        List<Node>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            // [노드, 인접 노드(다음 노드), 비용(가중치)]
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.destination]) {
                continue;
            }

            visited[now.destination] = true;

            for (Node next : adjList[now.destination]) {
                if (dist[next.destination] > now.cost + next.cost) {
                    dist[next.destination] = now.cost + next.cost;
                    pq.add(new Node(next.destination, dist[next.destination]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        // 그래프 정의: {출발 노드, 도착 노드, 가중치}
        int[][] graph = {
                {0, 1, 9},
                {0, 2, 3},
                {1, 0, 5},
                {2, 1, 1},
        };

        int start = 0; // 시작 노드
        int n = 3; // 노드 개수

        int[] result = solution(graph, start, n);
        System.out.println(Arrays.toString(result));
    }
}
