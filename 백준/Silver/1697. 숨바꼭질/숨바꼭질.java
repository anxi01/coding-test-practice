import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n, k;
  static int MAX = 100001;

  // 최소 시간을 저장하는 배열
  static int[] data = new int[100001];

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    System.out.println(bfs());
  }
  
  // BFS : Queue 이용
  public static int bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(n);

    while (!queue.isEmpty()) {
      int now = queue.poll();
      if (now == k) {
        return data[now];
      }
      int next = now - 1;
      if (0 <= next && next < MAX && data[next] == 0) {
        data[next] = data[now] + 1;
        queue.add(next);
      }
      next = now + 1;
      if (0 <= next && next < MAX && data[next] == 0) {
        data[next] = data[now] + 1;
        queue.add(next);
      }
      next = now * 2;
      if (0 <= next && next < MAX && data[next] == 0) {
        data[next] = data[now] + 1;
        queue.add(next);
      }
    }
    return -1;
  }
}
