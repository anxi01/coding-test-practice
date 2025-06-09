import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.print(factorial(N));
    }

    private static long factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return factorial(num - 1) * num;
    }
}
