import java.util.*;

/**
 * 최솟값을 구하는 문제 => 너비 우선 탐색(BFS)을 통해 최솟값 보장
 *
 * 풀이 과정:
 * 1. 시작 정점에서부터 BFS를 수행하여 최단 거리를 탐색합니다.
 * 2. Queue를 사용하여 BFS를 구현하며, 각 정점에서 상하좌우(UP, DOWN, LEFT, RIGHT)로 이동합니다.
 * 3. 이동 가능한 경우는 다음 조건을 만족해야 합니다:
 *    - 맵의 범위 내에 있어야 함 (유효한 인덱스 체크)
 *    - 벽(값이 0인 경우)이 아니어야 함
 *    - 아직 방문하지 않은 정점이어야 함
 * 4. 방문 가능한 정점을 Queue에 추가하고, 해당 정점의 최단 거리를 현재 정점의 거리 +1로 갱신합니다.
 * 5. BFS를 모두 수행한 뒤, 도착점(N-1, M-1)의 최단 거리를 확인합니다.
 *    - 도착점의 거리가 0인 경우, 도달할 수 없으므로 -1을 반환합니다.
 *    - 그렇지 않은 경우, 도착점의 최단 거리를 반환합니다.
 *
 * 시간 복잡도:
 * - BFS는 모든 정점(노드)과 간선을 탐색합니다.
 * - 맵의 크기가 N x M일 때, 정점의 수는 최대 N x M개입니다.
 * - 간선의 수는 각 정점에서 최대 4개(상하좌우 이동 가능성이 4가지)이므로, O(N x M x 4)입니다.
 * - 따라서 시간 복잡도는 O(N x M)입니다.
 */
class Solution {

    // x, y좌표 움직이는 경우의 수(UP, DOWN, LEFT, RIGHT)를 배열로 미리 생성
    private static final int[] mapx = new int[]{1, -1, 0, 0};
    private static final int[] mapy = new int[]{0, 0, 1, -1};

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        // 최단 거리를 x, y좌표를 idx로 생성하는 배열
        int[][] dist = new int[N][M];

        // BFS를 수행하기 위해, Queue를 사용하여 생성
        ArrayDeque<Node> queue = new ArrayDeque<>();
      
        // 시작 정점의 최단 거리 설정 및 큐에 삽입
        queue.add(new Node(0, 0));
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // UP, DOWN, LEFT, RIGHT 로 1번 이동 시 경우의 수가 4번이므로,
            // 4번 반복문 수행
            for (int i = 0; i < 4; i++) {
                int x = now.x + mapx[i];
                int y = now.y + mapy[i];

                // 유효한 인덱스가 아니면 연산 진행 X
                if (x < 0 || x >= N || y < 0 || y >= M) {
                    continue;
                }

                // 벽이 있으면 연산 진행 X
                if (maps[x][y] == 0) {
                    continue;
                }

                // 아직 방문하지 않은 경우(처음 방문)
                if (dist[x][y] == 0) {
                    queue.add(new Node(x, y));
                    dist[x][y] = dist[now.x][now.y] + 1;
                }
            }
        }

        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }
}
