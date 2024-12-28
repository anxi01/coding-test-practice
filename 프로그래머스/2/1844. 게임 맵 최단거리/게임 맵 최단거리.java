import java.util.*;

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
        queue.add(new Node(0, 0));
        dist[0][0] = 1; // 시작 정점의 최단 거리 설정

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // UP, DOWN, LEFT, RIGHT 로 1번 이동 시 경우의 수가 4번이므로,
            // 4번 반복문 수행
            for (int i = 0; i < 4; i++) {
                int x = now.x + mapx[i];
                int y = now.y + mapy[i];

                // 만약 좌표가 벗어나면, 다시 for문으로 회귀
                if (x < 0 || x >= N || y < 0 || y >= M) {
                    continue;
                }

                // 벽일 경우
                if (maps[x][y] == 0) {
                    continue;
                }

                // 처음 방문 했을 경우
                if (dist[x][y] == 0) {
                    queue.add(new Node(x, y));
                    dist[x][y] = dist[now.x][now.y] + 1;
                }
            }
        }

        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }
}
