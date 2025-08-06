import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] rx = {-1, 1, 0, 0};
    private static int[] ry = {0, 0, -1, 1};
    private static boolean[] alpha = new boolean[26];

    private static int R;
    private static int C;
    private static int answer;
    private static List<List<Character>> board = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            board.add(new ArrayList<>());
        }

        for (int row = 0; row < R; row++) {
            String s = br.readLine();
            for (int col = 0; col < C; col++) {
                char c = s.charAt(col);
                board.get(row).add(c);
            }
        }

        alpha[board.get(0).get(0) - 'A'] = true;
        backtrack(0, 0, 1);
        System.out.println(answer);
    }

    private static void backtrack(int row, int col, int cnt) {
        answer = Math.max(cnt, answer);

        for (int i = 0; i < 4; i++) {
            int nextX = row + rx[i];
            int nextY = col + ry[i];

            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) {
                continue;
            }

            char nextCharacter = board.get(nextX).get(nextY);

            if (!alpha[nextCharacter - 'A']) {
                alpha[nextCharacter - 'A'] = true;
                backtrack(nextX, nextY, cnt + 1);
                alpha[nextCharacter - 'A'] = false;
            }
        }
    }
}
