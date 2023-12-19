import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // "에라토스테네스의 체" 사용 (시간 초과 때문)
        boolean[] isPrime = new boolean[1000001];

        isPrime[0] = isPrime[1] = true; // 소수아닌 값 => true

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if(!isPrime[i]){
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = true;
                }
            }
        }


        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            boolean isProve = false;
            for (int i = 2; i <= n / 2; i++) {
                if (!isPrime[i] && !isPrime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    isProve = true;
                    break;
                }
            }
            if(!isProve) System.out.println("Goldbach's conjecture is wrong.");

        }
    }
}
