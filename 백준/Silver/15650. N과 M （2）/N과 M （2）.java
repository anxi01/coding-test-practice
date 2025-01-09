import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백트래킹 과정 : N = 3, M = 2일 경우,
 *
 * 1. backtrack(1, 0) 실행
 * start = 1, depth = 0
 * i = 1, sequence[0] = 1;
 * backtrack(2, 1);
 * ---
 * 2. backtrack(2, 1) 실행
 * start = 2, depth = 1
 * i = 2, sequence[1] = 2;
 * backtrack(3, 2);
 * ---
 * 3. backtrack(3, 2) 실헹
 * start = 3, depth = 2;
 * depth == M, answer = 1 2 & exit
 * ---
 * 4. backtrack(2, 1) 복귀
 * i = 3, sequence[1] = 3;
 * backtrack(4, 2);
 * ---
 * 5. backtrack(4, 2) 실행
 * start == M, answer = 1 3 & exit
 * ---
 * 6. backtrack(1, 0) 복귀
 * i = 2 sequence[0] = 2;
 * backtrack(3, 1);
 * ---
 * 7. backtrack(1, 1) 실행
 * i = 3, sequence[1] = 3;
 * ---
 * 8. backtrack(4, 2) 실행
 * start == M, answer = 2 3 & exit
 * ---
 * 9. backtrack(1, 0) 복귀
 * i = 3, 반복문 종료
 * 탐색 종료
 */
public class Main {

    private static int[] sequence;
    private static int N, M;
    private static StringBuilder answer = new StringBuilder();

    private static void backtrack(int start, int depth) {
        if (depth == M) {
            for (int value : sequence) {
                answer.append(value).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            sequence[depth] = i;
            backtrack(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M];

        backtrack(1, 0);
        System.out.print(answer);
    }
}
