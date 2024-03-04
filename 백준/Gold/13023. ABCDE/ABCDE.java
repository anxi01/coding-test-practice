import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static List<List<Integer>> data = new ArrayList<>();
  static boolean[] visited;

  // 5번째 노드까지 도착했는지 판단하는 변수
  static boolean arrive;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 초기 세팅
    visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      data.add(new ArrayList<>());
    }
    arrive = false;

    // 인접리스트 data에 그래프 데이터 저장
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      data.get(a).add(b);
      data.get(b).add(a);
    }

    // 노드마다 DFS 진행
    for (int i = 0; i < n; i++) {
      dfs(i, 1);
      if(arrive) break;
    }

    if (arrive) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }

  private static void dfs(int now, int depth) {
    if (depth == 5 || arrive) {
      arrive = true;
      return;
    }

    visited[now] = true;

    for (int i : data.get(now)) {
      if (!visited[i]) {
        dfs(i, depth + 1);
      }
    }

    // 2번 노드에서 3번 노드로 넘어갈 때 이후 dfs가 불가능 할 때
    // 다시 2번 노드로 되돌아와야 하는데 이때 2번 노드가 true로 되어있으면
    // 탐색이 불가능하기 때문에 방문 노드를 false 처리 해줘야 한다.
    visited[now] = false;
  }
}