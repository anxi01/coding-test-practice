import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static List<List<Integer>> data = new ArrayList<>();
  static boolean[] visited;
  static int count;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 초기 세팅
    visited = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
      data.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      data.get(u).add(v);
      data.get(v).add(u);
    }

    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        dfs(i);
        count++;
      }
    }
    System.out.println(count);
  }
  private static void dfs(int start) {
    if(visited[start]) return;

    visited[start] = true;
    for (int i = 0; i < data.get(start).size(); i++) {
      int next = data.get(start).get(i);
      dfs(next);
    }
  }
}