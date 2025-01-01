import java.util.ArrayList;
import java.util.List;

/**
 * 문제 분석 :
 * - 분할된 한 쪽의 송전탑의 개수를 구하는 전체 개수에서 한 쪽의 송전탑 개수를 구해서 빼도 구할 수 있음.
 * - answer = | (전체 노드 - 자식 트리의 노드 수) - 자식 트리의 노드 수 |
 * - 최적이나 최소를 구하라고 하지 않았기 때문에 깊이 우선 탐색을 사용한다.
 */
class Solution {

    private static boolean[] visited;
    private static List<Integer>[] adjList;
    private static int N, answer;

    public int solution(int n, int[][] wires) {
        N = n;

        // answer은 우선 노드의 개수로 설정 (큰 값으로 설정 후, 최소 값으로 반복해서 갱신)
        answer = n;

        adjList  = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 간선 제거 후에도 각 네트워크의 노드 개수를 정확히 계산하기 위해 양방향 탐색(연결) 필수
        for (int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }

        visited = new boolean[n + 1];
        dfs(1);
        return answer;
    }

    private static int dfs(int now) {
        visited[now] = true;

        // 자식 노드의 수를 저장하고 반환할 변수
        int sum = 0;

        // 연결된 모든 전선 확인
        for (int next : adjList[now]) {
            if (!visited[next]) {
                // 분할된 한 쪽의 송전탑(노드) 개수 = (전체 노드 - 자식 트리의 노드 수)
                // 다른 쪽의 송전탑(노드) 개수 = 전체 노드 - (전체 노드 - 자식 트리의 노드 수)
                int count = dfs(next);

                // 따라서 분할된 송전탑의 차이 = (전체 노드 - 자식 트리의 노드 수) - 자식 트리의 노드 수
                // => 전체 노드 - 자식 트리의 노드 수 * 2
                answer = Math.min(answer, Math.abs(N - count * 2));

                // 자식 노드의 수를 더함
                sum += count;
            }
        }

        // 전체 자식 노드의 수에 1(현재 now 노드)을 더해서 반환
        return sum + 1;
    }
}
