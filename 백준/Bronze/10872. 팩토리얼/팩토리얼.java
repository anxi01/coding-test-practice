import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(fac(n));
    }

    public static int fac(int number) {

        if (number == 0 || number == 1) {
            return 1;
        }else {
            return number * fac(number - 1);
        }
    }
}
