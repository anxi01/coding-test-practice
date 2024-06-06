import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    int[] sequence = new int[N];
    for (int i = 0; i < N; i++) {
      sequence[i] = Integer.parseInt(st.nextToken());
    }

    int sum = 0, max = 0;
    
    // 슬라이딩 윈도우
    for (int i = 0; i < N; i++) {
      sum += sequence[i];
      
      // 초기 값 설정
      // 처음 범위의 합을 최대 값으로 정의
      if (i == K - 1) {
        max = sum;
      }

      // 그 다음부터는 앞의 값을 제거하면서 합을 갱신함.
      // 갱신된 합과 최대 값을 비교
      if (i >= K) {
        sum -= sequence[i - K];
        max = Math.max(max, sum);
      }
    }
    System.out.println(max);
  }
}
