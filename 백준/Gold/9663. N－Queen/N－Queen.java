import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int N, cnt = 0;
    private static int[][] board;
    private static int[] dx = {-1, -1, -1};
    private static int[] dy = {0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        backtrack(0);
        System.out.println(cnt);
    }

    private static void backtrack(int row) {
        if (row == N) {
            cnt++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isPossible(row, col)) {
                board[row][col] = 1;
                backtrack(row + 1);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isPossible(int row, int col) {
        for (int dir = 0; dir < 3; dir++) {

            int nx = row;
            int ny = col;

            // 현재 퀸 위치의 모든 위칸을 전부 확인해야하기 때문에 while 사용
            // 만약 위칸만 확인할거면 필요 없음.
            while (true) {
                nx += dx[dir];
                ny += dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;

                if (board[nx][ny] == 1) return false;
            }
        }

        return true;
    }
}
