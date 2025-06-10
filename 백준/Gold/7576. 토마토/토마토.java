import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] tomatoMap = new int[N][M];
        ArrayDeque<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                tomatoMap[i][j] = Integer.parseInt(st.nextToken());

                if (tomatoMap[i][j] == 1) {
                    queue.add(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (tomatoMap[nextX][nextY] == 0) {
                    tomatoMap[nextX][nextY] = tomatoMap[nowX][nowY] + 1;
                    queue.add(new Node(nextX, nextY));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoMap[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }

                max = Math.max(max, tomatoMap[i][j]);
            }
        }

        // 초기 익은 토마토의 값이 1로 시작하므로, 실제 걸린 일수는 max - 1
        System.out.print(max - 1);
    }
}
