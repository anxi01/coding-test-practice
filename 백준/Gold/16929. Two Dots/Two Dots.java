import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dr = {0, 0, -1, 1};
    private static final int[] dc = {-1, 1, 0, 0};

    private static int N, M;
    private static char[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 방문하지 않은 경로에서만 탐색
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, board[i][j])) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }

    private static boolean dfs(int row, int col, int prevRow, int prevCol, char color) {
        // 이미 방문한 곳에 다시 도달한 경우 => 사이클 완성
        if (visited[row][col]) {
            return true;
        }

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = row + dr[i];
            int nextC = col + dc[i];

            // 범위 검증
            if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
                continue;
            }

            // 같은 색깔 검증
            if (board[nextR][nextC] != color) {
                continue;
            }

            // 직전 칸 되돌아가는지 검증
            if (prevRow == nextR && prevCol == nextC) {
                continue;
            }

            if (dfs(nextR, nextC, row, col, color)) {
                return true;
            }
        }

        return false;
    }
}
