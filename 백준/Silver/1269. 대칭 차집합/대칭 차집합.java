import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int[] a = new int[A];
    int[] b = new int[B];
    Map<Integer, Integer> mapA = new HashMap<>();
    Map<Integer, Integer> mapB = new HashMap<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < A; i++) {
      a[i] = Integer.parseInt(st.nextToken());
      mapA.put(a[i], mapA.getOrDefault(a[i], 0) + 1);
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < B; i++) {
      b[i] = Integer.parseInt(st.nextToken());
      mapB.put(b[i], mapB.getOrDefault(b[i], 0) + 1);
    }

    int intersection = 0;

    // 교집합 계산
    for (int key : mapA.keySet()) {
      if (mapB.containsKey(key)) {
        intersection++;
      }
    }

    int union = mapA.size() + mapB.size() - 2 * intersection;

    System.out.println(union);
  }
}
