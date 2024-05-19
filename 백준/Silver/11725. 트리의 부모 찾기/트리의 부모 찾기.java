import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static boolean[] visited;
  public static int[] parent;
  public static List<List<Integer>> nodes;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;

    nodes = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      nodes.add(new ArrayList<>());
    }

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      nodes.get(a).add(b);
      nodes.get(b).add(a);
    }

    visited = new boolean[N + 1];
    parent = new int[N + 1];

    findParent(1);

    // 2번 노드의 부모부터 순서대로 출력
    for (int i = 2; i <= N; i++) {
      System.out.println(parent[i]);
    }
  }

  private static void findParent(int current) {
    // 현재 노드 방문
    visited[current] = true;

    for (int node : nodes.get(current)) {
      // 현재 노드에서 넘어간 노드가 방문하지 않은 노드면
      // 현재 노드를 부모 노드로 설정하고
      // 재귀로 다시 탐색한다.
      if (!visited[node]) {
        parent[node] = current;
        findParent(node);
      }
    }
  }
}