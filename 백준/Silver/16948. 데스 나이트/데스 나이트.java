import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};
    static int[][] dist;
    static int N, r1, c1, r2, c2;

    static class Horse {
        int r, c;

        Horse(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        ArrayDeque<Horse> queue = new ArrayDeque<>();
        queue.addLast(new Horse(r1, c1));
        dist[r1][c1] = 0;

        while (!queue.isEmpty()) {
            Horse now = queue.pollFirst();

            for (int i = 0; i < 6; i++) {
                int nextR = now.r + dr[i];
                int nextC = now.c + dc[i];

                // 체스판 벗어남
                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) {
                    continue;
                }

                // 방문 확인
                if (dist[nextR][nextC] != Integer.MAX_VALUE) {
                    continue;
                }

                // 데스나이트 도달
                if (nextR == r2 && nextC == c2) {
                    System.out.println(dist[now.r][now.c] + 1);
                    return;
                }

                // 새로운 말 추가
                queue.addLast(new Horse(nextR, nextC));
                if (dist[nextR][nextC] > dist[now.r][now.c] + 1) {
                    dist[nextR][nextC] = dist[now.r][now.c] + 1;
                }
            }
        }

        if (dist[r2][c2] == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
    }
}
