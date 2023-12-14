import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = 1;
            ArrayList<Integer> gcdList = new ArrayList<>();
            while (gcd <= Math.min(a, b)) {
                if (a % gcd == 0 && b % gcd == 0) {
                    gcdList.add(gcd);
                }
                gcd++;
            }
            gcd = Collections.max(gcdList);
            System.out.println(gcd * (a / gcd) * (b / gcd));
        }
    }
}
