import java.util.ArrayDeque;

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

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
        }

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

        int startLever = bfs(start, lever);
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

                if (dist[nextX][nextY] > 0) {
                    continue;
                }

                if (map[nextX][nextY] == 'X') {
                    continue;
                }

                dist[nextX][nextY] = dist[now.r][now.c] + 1;
                queue.add(new Node(nextX, nextY));

                if (nextX == end.r && nextY == end.c) {
                    return dist[end.r][end.c];
                }
            }
        }
        return -1;
    }
}
