import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayDeque<Integer> queue = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "push":
          queue.addLast(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          sb.append(queue.peekFirst() == null ? -1 : queue.pollFirst()).append("\n");
          break;
        case "size":
          sb.append(queue.size()).append("\n");
          break;
        case "empty":
          sb.append(queue.isEmpty() ? 1 : 0).append("\n");
          break;
        case "front":
          sb.append(queue.peekFirst() == null ? -1 : queue.peekFirst()).append("\n");
          break;
        case "back":
          sb.append(queue.peekLast() == null ? -1 : queue.peekLast()).append("\n");
          break;
      }
    }
    System.out.println(sb);
  }
}
