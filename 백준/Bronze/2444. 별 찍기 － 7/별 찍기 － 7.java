import java.io.*;

// 문자열 반복은 String.repeat() 사용하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int starCount = 2 * i - 1;
            sb.append(" ".repeat(N - i));
            sb.append("*".repeat(starCount));
            sb.append("\n");
        }

        for (int i = N - 1; i >= 1; i--) {
            int starCount = 2 * i - 1;
            sb.append(" ".repeat(N - i));
            sb.append("*".repeat(starCount));
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
