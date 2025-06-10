import java.io.*;
import java.util.*;

public class Main {

    private static class Balloon {
        int index, value;

        Balloon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        ArrayDeque<Balloon> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            deque.addLast(new Balloon(i + 1, value));
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            Balloon current = deque.pollFirst();
            sb.append(current.index).append(" ");

            if (!deque.isEmpty()) {
                int order = current.value;
                if (order > 0) {
                    // 양수: 오른쪽 이동 (앞에서 빼서 뒤로 추가)
                    for (int i = 0; i < order - 1; i++) {
                        deque.addLast(deque.pollFirst());
                    }
                } else {
                    // 음수: 왼쪽 이동 (뒤에서 빼서 앞으로 추가)
                    for (int i = 0; i < Math.abs(order); i++) {
                        deque.addFirst(deque.pollLast());
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
