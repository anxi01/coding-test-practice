import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] used;
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean[N + 1];

        backtrack(0, "");
        System.out.println(sb);
    }

    private static void backtrack(int cnt, String s) {
        if (cnt == M) {
            sb.append(s.trim() + "\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            backtrack(cnt + 1, s + " " + i);
        }
    }
}
