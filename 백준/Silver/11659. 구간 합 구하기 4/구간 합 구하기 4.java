import java.io.*;
import java.util.StringTokenizer;

/**
 * 누적합 (Prefix Sum):
 * - 주어지는 수가 불변일 때 사용한다.
 * - 시간 복잡도가 O(N)이다.
 *  - 누적 합을 저장 : O(N)
 *  - 누적 합을 인덱스 별로 조회 : O(1)
 * ---
 * 시간 제한 : 1초
 * 메모리 제한 : 256 MB
 * N, M <= 100,000
 * ---
 * 시간 복잡도 : 1초 = 10^8 100,000,000 (1억)회 연산 가능 -> O(N), O(NlogN)까지 가능
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        // 배열에 수를 넣으면서 동시에 누적합 구하기
        arr[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write((arr[end] - arr[start - 1]) + "\n");
        }

        bw.flush();
    }
}
