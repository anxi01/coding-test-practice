import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        /**
         *  시간 초과 -> 계수정렬 이용(입력값의 등장 횟수를 index에 증가)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[10001];

        for (int i = 0; i < n; i++) {
            list[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10001; i++) {
            if (list[i] != 0) {
                for (int j = 0; j < list[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}