import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n, m, v;

  // 인접 리스트
  static List<List<Integer>> adj = new ArrayList<>();

  // 방문한 정점은 다시 방문하지 않도록 false를 기본값으로 설정
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      adj.get(x).add(y);
      adj.get(y).add(x);
    }

    for (int i = 1; i <= n; i++) {
      Collections.sort(adj.get(i));
    }

    visited = new boolean[n + 1];
    dfs(v);
    sb.append("\n");
    visited = new boolean[n + 1];
    bfs(v);

    System.out.println(sb);
  }

  // DFS : Stack or 재귀 이용
  public static void dfs(int v) {
    if (visited[v]) return;

    visited[v] = true;
    sb.append(v + " ");
    for (int i = 0; i < adj.get(v).size(); i++) {
      int y = adj.get(v).get(i);
      dfs(y);
    }
  }

  // BFS : Queue 이용
  public static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      sb.append(now + " ");
      for (int i = 0; i < adj.get(now).size(); i++) {
        int y = adj.get(now).get(i);
        if (!visited[y]) {
          queue.offer(y);
          visited[y] = true;
        }
      }
    }
  }
}
