import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백트래킹 과정 : N = 3, M = 2일 경우,
 *
 * 1. backtrack(0) 실행
 * start = 0:
 * i = 1, visited[1] = true;
 * sequence[0] = 1;
 * ---
 * 2. backtrack(1) 실행
 * start = 1;
 * i = 1, 이미 방문
 * i = 2, visited[2] = true;
 * sequence[1] = 2;
 * ---
 * 3. backtrack(2) 실헹
 * start = 2;
 * start == M, answer = 1 2 & exit
 * ---
 * 4. backtrack(1) 복귀
 * i = 2 종료, visited[2] = false;
 * i = 3, visited[3] = true;
 * sequence[1] = 3;
 * ---
 * 5. backtrack(2) 실행
 * start == M, answer = 1 3 & exit
 * ---
 * 6. backtrack(1) 복귀
 * i = 3 종료, visited[3] = false;
 * ---
 * 7. backtrack(0) 복귀
 * i = 1 종료, visited[1] = false;
 * i = 2, visited[2] = true;
 * sequence[0] = 2;
 * ---
 * 8. backtrack(1) 실행
 * i = 1, visited[1] = true;
 * sequence[1] = 1
 * ...
 * 반복
 */

/**
 * 백트래킹 풀이과정: 트리로 생각하면 편함!
 * 1. 초기화:
 * - N과 M 값을 입력받습니다.
 * - sequence는 길이 M의 수열을 저장하기 위해 크기 M의 배열로 초기화합니다.
 * - visited는 숫자가 사용되었는지 추적하기 위해 크기 N + 1의 불리언 배열로 초기화합니다.
 * - backtrack(0)을 호출하여 수열 생성을 시작합니다.
 *
 * 2. 백트래킹 함수(backtrack):
 * - start: 현재 수열에서 채울 인덱스를 나타냅니다.
 *
 * 2.1 종료 조건 (유망 함수 조건):
 * - start == M이면 수열이 완성된 상태입니다.
 * - sequence 배열의 값을 answer에 저장한 뒤 함수를 종료합니다.
 *
 * 2.2 숫자 선택:
 * - for (int i = 1; i < N + 1; i++)를 통해 1부터 N까지의 숫자를 반복 탐색합니다.
 * - if (!visited[i]) 조건으로 현재 숫자가 사용되지 않은 경우에만 선택합니다.
 *
 * 2.3 상태 업데이트 및 재귀 호출:
 * - visited[i] = true: 선택된 숫자를 방문 처리합니다.
 * - sequence[start] = i: 현재 위치에 선택된 숫자(i)를 저장합니다.
 * - backtrack(start + 1): 다음 인덱스를 채우기 위해 재귀 호출합니다.
 *
 * 2.4 백트래킹:
 * - 재귀 호출이 종료되면, 이전 상태로 되돌리기 위해 visited[i] = false로 초기화합니다.
 * ---
 * 재귀 호출에서는 스택으로 쌓이고, 다시 되돌아올 때(백트래킹) 진행된 i 다음부터 시작한다.
 */
public class Main {

    private static boolean[] visited;
    private static int[] sequence;
    private static int N, M;

    private static StringBuilder answer = new StringBuilder();

    private static void backtrack(int start) {
        // 유망 함수 조건 1. 수열 길이의 size가 M일 경우, 출력에 추가하기
        if (start == M) {
            for (int value : sequence) {
                answer.append(value).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) { // 인덱스 1부터 시작
            if (!visited[i]) {
                visited[i] = true;
                sequence[start] = i; // 1부터 시작하는 값 저장
                backtrack(start + 1);   // 다음 위치로 이동
                visited[i] = false;    // 백트래킹
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M];
        visited = new boolean[N + 1];

        backtrack(0);
        System.out.print(answer);
    }
}
