import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> results = new ArrayList<>();

        int result = 2;
        while (n != 1) {
            if (n % result == 0) {
                results.add(result);
                n /= result;
            } else {
                result++;
            }
        }
        if (!results.isEmpty()) {
            Collections.sort(results);
            for (int r : results) {
                System.out.println(r);
            }
        }
    }
}
