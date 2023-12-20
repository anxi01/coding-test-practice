import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] data = new int[n];
            for (int j = 0; j < n; j++) {
                data[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for (int l = 0; l < n - 1; l++) {
                for (int p = l + 1; p < n; p++) {
                    sum += gcd(data[l], data[p]);
                }
            }
            System.out.println(sum);
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
