import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            if(i < 2) sb1.append(st.nextToken());
            else sb2.append(st.nextToken());
        }

        System.out.printf("%.0f", Double.parseDouble(sb1.toString()) + Double.parseDouble(sb2.toString()));
    }
}
