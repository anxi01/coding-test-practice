import java.util.ArrayDeque;

/**
 * 풀이과정
 * - 37. 게임 맵 최단거리와 유사하지만, String 문자열로 입력 받는 형태.
 *
 * Key Point : 따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다.
 * - 출발 지점 -> 레버
 * - 레버 -> 종료 지점
 * 위 2개의 경우를 분리해서 최소 시간을 구한 후 합치는 형태로 풀어야 함.
 *
 * 시간 복잡도 : O(N^2) - 최대 N * M일 경우(지도 완전 탐색)
 */
class Solution {
    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    private static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static char[][] map;
    private static int N, M;

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        // maps(미로)의 정보를 char 배열로 생성
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
        }

        // 시작, 종료, 레버 위치를 찾음
        Node start = null, end = null, lever = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') {
                    start = new Node(i, j);
                } else if (map[i][j] == 'E') {
                    end = new Node(i, j);
                } else if (map[i][j] == 'L') {
                    lever = new Node(i, j);
                }
            }
        }

        // 시작 지점 -> 레버 최단 거리 구하기
        int startLever = bfs(start, lever);

        // 레버 -> 종료 지점 최단 거리 구하기
        int leverEnd = bfs(lever, end);

        if (startLever == -1 || leverEnd == -1) {
            return -1;
        } else {
            return startLever + leverEnd;
        }
    }

    private static int bfs(Node start, Node end) {
        int[][] dist = new int[N][M];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.r + rx[i];
                int nextY = now.c + ry[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (map[nextX][nextY] == 'X') {
                    continue;
                }

                if (dist[nextX][nextY] > 0) {
                    continue;
                }

                dist[nextX][nextY] = dist[now.r][now.c] + 1;
                queue.add(new Node(nextX, nextY));

                /* 이것도 가능
                if (dist[nextX][nextY] == 0) {
                    dist[nextX][nextY] = dist[now.r][now.c] + 1;
                    queue.add(new Node(nextX, nextY));
                }
                 */

                // 도착지에 도달하면 최단 거리 반환
                if (nextX == end.r && nextY == end.c) {
                    return dist[end.r][end.c];
                }
            }
        }
        // 도착지에 도달하지 못하면 -1 반환
        return -1;
    }
}
