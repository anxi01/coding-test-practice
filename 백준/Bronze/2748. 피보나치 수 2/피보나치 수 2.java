import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo_dp(n));
    }

    public static long fibo_dp(int num) {

        // Memoization
        long[] cache = new long[num + 1];
        cache[0] = 0;
        cache[1] = 1;

        for (int index = 2; index < cache.length; index++) {
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[num];
    }
}
