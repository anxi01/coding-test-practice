import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    /**
     * 비행 스케줄은 항상 연결 그래프를 이루며,
     * 각 노드(국가)를 연결하는 간선이 비행기 종류이므로,
     * 모든 국가를 여행하려면 "노드 개수 - 1" 을 하면 된다.
     */
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      for (int j = 0; j < M; j++) {
        st = new StringTokenizer(br.readLine());
      }
      System.out.println(N - 1);
    }
  }
}