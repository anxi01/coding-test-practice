import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      int temp = Integer.parseInt(st.nextToken());
      map.put(temp, map.getOrDefault(temp, 0) + 1);
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      int temp = Integer.parseInt(st.nextToken());

      if (map.containsKey(temp)) {
        sb.append(1).append("\n");
      } else {
        sb.append(0).append("\n");
      }
    }
    System.out.println(sb);
  }
}