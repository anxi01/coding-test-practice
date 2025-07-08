import java.io.*;
import java.util.*;

public class Main {

    private static class Document {
        int value;
        boolean isFind;

        Document(int value, boolean isFind) {
            this.value = value;
            this.isFind = isFind;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            ArrayDeque<Document> queue = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (j == M) {
                    queue.addLast(new Document(value, true));
                } else {
                    queue.addLast(new Document(value, false));
                }

                pq.add(value);
            }

            int order = 0;
            while (!queue.isEmpty() && !pq.isEmpty()) {
                int maxPriority = pq.peek();

                Document current = queue.peekFirst();

                if (current.value == maxPriority) {
                    queue.pollFirst();
                    pq.poll();
                    order++;

                    if (current.isFind) {
                        System.out.println(order);
                        break;
                    }
                } else {
                    queue.addLast(queue.pollFirst());
                }
            }
        }
    }
}
