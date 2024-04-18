import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    List<String> list = new ArrayList<>();
    int count = 0;
    for (int i = 0; i < m; i++) {
      String arg = br.readLine();
      if (set.contains(arg)) {
        count++;
        list.add(arg);
      }
    }

    System.out.println(count);

    Collections.sort(list);
    for (String s : list) {
      System.out.println(s);
    }
  }
}