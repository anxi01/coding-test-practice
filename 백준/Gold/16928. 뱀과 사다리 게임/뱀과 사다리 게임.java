import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] ladders = new int[101];
    static int[] snakes = new int[101];
    static int[] dist = new int[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ladders[x] = y;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            snakes[u] = v;
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next < 1 || next > 100) {
                    continue;
                }

                if (next == 100) {
                    System.out.println(dist[now] + 1);
                    return;
                }

                if (ladders[next] > 0) {
                    next = ladders[next];
                } else if (snakes[next] > 0) {
                    next = snakes[next];
                }

                // 방문 체크, 더 빠른(횟수 적은) 값으로 갱신 가능할 경우 Queue에 넣음
                if (dist[next] > dist[now] + 1) {
                    dist[next] = Math.min(dist[now] + 1, dist[next]);
                    queue.addLast(next);
                }
            }
        }
    }
}
