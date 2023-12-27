import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Character> data = new ArrayList<>();

        while (n > 0) {
            if (n % b < 10) {
                data.add((char) (n % b + '0'));
            } else {
                data.add((char) (n % b + 'A' - 10));
            }

            n /= b;
        }

        // 처음 나눈 나머지 값이 마지막에 출력돼야함
        // => LIFO 느낌
        for (int i = data.size() - 1; i >= 0; i--) {
            System.out.print(data.get(i));
        }
    }
}
