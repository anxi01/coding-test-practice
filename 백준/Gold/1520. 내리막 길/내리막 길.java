import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {1, -1, 0, 0};

    private static int[][] map;
    private static int[][] cnt;

    private static int M, N;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        cnt = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cnt[i][j] = -1; // cnt 배열의 초기값을 0으로 설정 (경로가 0개일 수도 있으므로, int 배열의 기본값인 0을 쓰는 것은 위험)
            }
        }

        // 도착점에서 도착점까지 가는 방법은 하나
        // 도착지임을 미리 설정 if (cnt[now.r][now.c] > 0) 에서 return됨. 즉 도착지에서 dfs가 끝남.
        cnt[M - 1][N - 1] = 1;

        dfs(new Node(0, 0));
        System.out.print(cnt[0][0]);
    }

    private static int dfs(Node now) {
        // 노드의 경로 수를 계산했으면, 다시 DFS 하지 않고 즉시 반환
        if (cnt[now.r][now.c] > -1) {
            return cnt[now.r][now.c];
        }

        cnt[now.r][now.c] = 0;

        for (int i = 0; i < 4; i++) {
            int nr = now.r + rx[i];
            int nc = now.c + ry[i];

            // 범위 벗어남
            if (nr < 0 || nc < 0 || nr >= M || nc >= N) {
                continue;
            }

            // 내리막길인 경우
            if (map[now.r][now.c] > map[nr][nc]) {
                cnt[now.r][now.c] += dfs(new Node(nr, nc));
            }
        }

        // 최종적으로 계산된 경로 수 반환
        return cnt[now.r][now.c];
    }
}
