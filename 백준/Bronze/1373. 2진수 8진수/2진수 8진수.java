import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String binary = br.readLine();

        StringBuilder sb = new StringBuilder();
        int sum = 0;

        // 8진수 -> 2진수 3개씩 묶어서 가능
        // 2진수의 길이 - 현재 인덱스 값 % 3 = 021 / 021/ 021 ... 반복
        // 따라서, 0일 때 4를 곱해주고, 2일 때 2를 곱하고, 1일 때 현 숫자를 더해준다.
        for (int i = 0; i < binary.length(); i++) {
            int num = binary.charAt(i) - '0';
            switch ((binary.length() - i) % 3) {
                case 0:
                    sum += 4 * num;
                    break;
                case 2:
                    sum += 2 * num;
                    break;
                case 1:
                    sum += num;
                    sb.append(sum);
                    sum = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
