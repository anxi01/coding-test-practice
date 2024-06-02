import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    // Two Pointer 문제
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] A = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    int start = 0, end = 0, sum = 0, count = 0;
    while (true) {
      if (sum >= M) {
        sum -= A[start];
        start++;
      } else if (end == N) {
        break;
      } else {
        sum += A[end];
        end++;
      }
      if (sum == M) {
        count++;
      }
    }
    System.out.println(count);
  }
}
