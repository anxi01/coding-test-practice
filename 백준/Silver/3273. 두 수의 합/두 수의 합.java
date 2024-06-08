import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    int[] sequence = new int[n];
    for (int i = 0; i < n; i++) {
      sequence[i] = Integer.parseInt(st.nextToken());
    }

    int x = Integer.parseInt(br.readLine());

    Arrays.sort(sequence);

    int start = 0;
    int end = n - 1;
    int count = 0;
    
    while (start < end) {
      int sum = sequence[start] + sequence[end];
      if (sum == x) {
        count++;
        start++;
        end--;
      } else if (sum < x) {
        start++;
      } else {
        end--;
      }
    }
    System.out.println(count);
  }
}
