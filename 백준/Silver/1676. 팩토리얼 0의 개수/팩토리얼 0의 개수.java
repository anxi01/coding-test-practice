import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        // 끝이 0인 수는 2 X 5 의 거듭제곱으로 이뤄져있어야 한다.
        // 10일 경우, 10! = 2^8 * 3^4 * 5^2 * 7이 되고
        // 수가 커질 수록 5의 개수가 증가하기 때문에
        // 5의 제곱수만큼 count에 더해주면 된다.
        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }
        System.out.println(cnt);

    }
}
