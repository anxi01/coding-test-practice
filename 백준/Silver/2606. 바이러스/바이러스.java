import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer>[] adjList;
    private static boolean[] visited;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터 수(노드)
        int m = Integer.parseInt(br.readLine()); // 간선 수

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        visited = new boolean[n + 1];

        cnt = 0;
        dfs(1);
        
        // dfs 하면서 노드 탐색 시 cnt를 1씩 증가하였음
        // 1번 컴퓨터는 cnt를 제외해야 하므로 1을 빼줌
        System.out.println(cnt - 1);
    }

    private static void dfs(int now) {
        visited[now] = true;
        cnt++;

        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
