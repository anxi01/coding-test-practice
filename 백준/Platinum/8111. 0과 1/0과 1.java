import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Node {
        int remain;
        String number;

        Node(int remain, String number) {
            this.remain = remain;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Integer> inputs = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            inputs.add(Integer.parseInt(br.readLine()));
        }

        for (int input : inputs) {
            ArrayDeque<Node> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[input + 1];
            queue.addLast(new Node(1 % input, "1"));

            while (!queue.isEmpty()) {
                Node now = queue.pollFirst();
                if (visited[now.remain]) {
                    continue;
                }
                visited[now.remain] = true;

                if (now.number.length() >= 100) {
                    System.out.println("BRAK");
                    break;
                }

                if (now.remain == 0) {
                    System.out.println(now.number);
                    break;
                }

                // 11을 3으로 나눴을 경우.
                // 11 = (3 * 3) + 2  (나머지: 2)

                // 110를 3으로 나눈 나머지를 구하고 싶다.
                // 11 * 10 = (3 * 3 * 10) + (2 * 10)
                // 여기서 (3 * 3 * 100)은 3의 배수이므로 버린다.
                // 따라서 110의 나머지는 (2 * 10)의 나머지인 20 % 3과 같다.
                int nextRemain1 = (now.remain * 10) % input;
                int nextRemain2 = (now.remain * 10 + 1) % input;

                if (!visited[nextRemain1]) {
                    queue.addLast(new Node(nextRemain1, now.number + "0"));
                }

                if (!visited[nextRemain2]) {
                    queue.addLast(new Node(nextRemain2, now.number + "1"));
                }
            }
        }
    }
}
