import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int fibCount = 0;
    private static int fibonacciCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 1;

        fib(n);
        fibonacci(f, n);

        System.out.print(fibCount + " " + fibonacciCount);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            fibCount++;
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    private static void fibonacci(int[] f, int n) {
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            fibonacciCount++;
        }
    }
}
