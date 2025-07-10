import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] heights = new int[N + 1];
        int[] result = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] < heights[i]) {
                stack.pollLast();
            }

            result[i] = stack.isEmpty() ? 0 : stack.peekLast();
            stack.addLast(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
    }
}
