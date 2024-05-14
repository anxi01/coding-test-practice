import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      String name = st.nextToken();
      String record = st.nextToken();

      if (record.equals("enter")) {
        map.put(name, map.getOrDefault(name, 0) + 1);
      } else if (record.equals("leave")) {
        map.put(name, map.get(name) - 1);
      }
    }

    map.keySet().stream().filter(s -> map.get(s) > 0).sorted(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o2.compareTo(o1);
      }
    }).forEach(System.out::println);
  }
}