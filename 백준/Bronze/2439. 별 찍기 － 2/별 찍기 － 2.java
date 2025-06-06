import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringBuilder sb = new StringBuilder();
            int blankCnt = N - i;

            for (int j = 0; j < blankCnt; j++) {
                sb.append(" ");
            }

            for (int k = 0; k < i; k++) {
                sb.append("*");
            }

            System.out.println(sb);
        }
    }
}
