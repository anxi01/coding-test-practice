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

            if(isPrime(num)) count++;
        }

        System.out.println(count);
    }

    public static boolean isPrime(int number) {
        if(number == 1) return false;

        for (int i = 2; i < number; i++) {

            if(number % i == 0) return false;
        }

        return true;
    }
}
