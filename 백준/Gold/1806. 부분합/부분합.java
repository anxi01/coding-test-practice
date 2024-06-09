import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    int[] sequence = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      sequence[i] = Integer.parseInt(st.nextToken());
    }

    int start = 0, end = 0, sum = 0;
    int minLength = Integer.MAX_VALUE;

    while (true) {
      if (sum >= S) {
        minLength = Math.min(minLength, end - start);
        sum -= sequence[start];
        start++;
      } else if (end == N) {
        break;
      } else {
        sum += sequence[end];
        end++;
      }
    }

    if (minLength == Integer.MAX_VALUE) {
      System.out.println(0);
    } else {
      System.out.println(minLength);
    }
  }
}
