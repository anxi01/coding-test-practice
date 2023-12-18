import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            int idx = 2;
            while (num != 1 && idx <= num) {
                if (idx == num) {
                    count++;
                }
                if (num % idx == 0) {
                    break;
                }
                idx++;
            }
        }

        System.out.println(count);
    }
}
