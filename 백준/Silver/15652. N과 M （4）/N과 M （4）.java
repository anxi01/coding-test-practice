import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backtrack(0, 1, "");
        System.out.println(sb);
    }

    private static void backtrack(int cnt, int now, String s) {
        if (cnt == M) {
            sb.append(s.trim() + "\n");
            return;
        }

        for (int i = now; i <= N; i++) {
            backtrack(cnt + 1, i, s + " " + i);
        }
    }
}
