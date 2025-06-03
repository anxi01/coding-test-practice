import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
            PriorityQueue<Integer> right = new PriorityQueue<>(); // 최소 힙

            sb.append((M + 1) / 2).append("\n");

            int count = 0;
            int printed = 0;
            while (count < M) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());
                    count++;

                    // 1. 중앙값을 위한 힙 분배
                    /*
                      - 현재 수(num)를 기준으로:
                        - 중앙값 이하인 값들은 left(최대 힙)에,
                        - 중앙값 초과인 값들은 right(최소 힙)에 저장
                     */
                    if (left.isEmpty() || num <= left.peek()) {
                        left.add(num);
                    } else {
                        right.add(num);
                    }

                    // 2. 두 힙의 크기를 균형 있게 유지 (left는 최대 1개 더 많게)
                    /*
                      - left.size()는 항상 right.size()보다 같거나 1 많아야
                        중앙값을 left.peek()로 유지 가능
                     */
                    if (left.size() > right.size() + 1) {
                        right.add(left.poll());
                    } else if (right.size() > left.size()) {
                        left.add(right.poll());
                    }

                    // 3. 홀수일 때, left 힙에서 가져오기
                    if (count % 2 == 1) {
                        sb.append(left.peek()).append(" ");
                        printed++;

                        // 한 줄에 10개 출력하기
                        if (printed % 10 == 0) sb.append("\n");
                    }
                }
            }

            // 마지막 줄 개행 정리하기
            if (printed % 10 != 0) sb.append("\n");
        }

        System.out.print(sb);
    }
}
