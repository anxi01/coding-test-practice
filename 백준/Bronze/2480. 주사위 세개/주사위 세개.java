import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0) + 1);
            max = Math.max(max, n);
        }

        int result = 0;

        if (map.containsValue(3)) {
            for (int key : map.keySet()) {
                if (map.get(key) == 3) {
                    result = 10000 + key * 1000;
                    break;
                }
            }
        } else if (map.containsValue(2)) {
            for (int key : map.keySet()) {
                if (map.get(key) == 2) {
                    result = 1000 + key * 100;
                    break;
                }
            }
        } else {
            result = max * 100;
        }

        System.out.println(result);
    }
}
