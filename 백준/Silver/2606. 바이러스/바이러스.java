import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> computerNet = new ArrayList<>();

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            computerNet.add(new ArrayList<>());
        }

        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            computerNet.get(c1).add(c2); // 무방향그래프
            computerNet.get(c2).add(c1); // 무방향그래프
        }

        dfs(1);

        int answer = 0;
        for (int i = 2; i <= N; i++) {
            if (visited[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int now) {
        if (visited[now]) {
            return;
        }

        visited[now] = true;

        for (int next : computerNet.get(now)) {
            dfs(next);
        }
    }
}
