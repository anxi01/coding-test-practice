import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 풀이과정:
 * 1. 배추가 존재하는 위치(1)는 2차원 배열에 true로 설정한다.
 * 2. 행과 열의 index를 이중 for문을 사용해서 전체 탐색을 진행한다.
 *  - 방문을 하지 않았고,
 *  - 배추가 존재하는 위치일 때
 *  -> dfs를 진행한다.
 *
 * dfs:
 * - 방문 여부 2차원 배열에 현재 위치를 true로 설정한다.
 * - 상하좌우 4번의 위치를 순회하면서
 *  1. 행과 열의 index를 벗어나지 않은 경우
 *  2. 배추가 존재하는 위치일 경우
 *  3. 아직 방문하지 않은 위치일 경우
 *  -> dfs를 재귀 수행한다.
 */
public class Main {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int M, N, K;

    private static boolean[][] cabbage, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            cabbage = new boolean[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[x][y] = true;
            }

            int count = 0;

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbage[x][y] && !visited[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) {
                continue;
            }

            if (cabbage[nextX][nextY] && !visited[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }
}
