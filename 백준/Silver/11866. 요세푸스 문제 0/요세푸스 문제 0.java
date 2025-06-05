import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int order = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.addLast(queue.pollFirst());
            }
            order++;

            if (order == N) {
                sb.append(queue.pollFirst()).append(">");
            } else {
                sb.append(queue.pollFirst()).append(", ");
            }
        }

        System.out.print(sb);
    }
}
