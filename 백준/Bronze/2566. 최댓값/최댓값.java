import java.io.*;
import java.util.*;

// 입력 값이 모두 0일 경우, x와 y도 (0, 0)으로 출력되는 문제 발생
// 따라서 Integer.MIN_VALUE 로 설정하여 위 문제 방지
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] answer = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                int element = Integer.parseInt(st.nextToken());
                answer[i][j] = element;
            }
        }

        int max = Integer.MIN_VALUE;
        int x = 0, y = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int curr = answer[i][j];
                if (max < curr) {
                    max = curr;
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);
    }
}
