import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = m; i <= n; i++) {
            if(isPrime(i)) System.out.println(i);
        }
    }

    public static boolean isPrime(int number) {
        if(number == 1) return false;

        // 제곱근을 이용한 기본 판별법
        for (int i = 2; i <= Math.sqrt(number); i++) {

            if(number % i == 0) return false;
        }

        return true;
    }
}
