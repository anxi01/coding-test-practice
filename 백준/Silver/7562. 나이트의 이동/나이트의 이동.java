import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 출발지에서 갈 수 있는 모든 후보지를 하나의 레벨에서 관리하기 (queue.size())
public class Main {

    private static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(st.nextToken());
            int nowY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            // 출발지와 도착지가 같을 경우, 바로 끝내기
            if (nowX == endX && nowY == endY) {
                System.out.println(0);
                continue;
            }

            ArrayDeque<Node> queue = new ArrayDeque<>();
            visited[nowX][nowY] = true;
            queue.add(new Node(nowX, nowY));

            int moveCount = 0;
            boolean found = false; // 도착지 도달 시, 종료하는 플래그 변수 초기화
            while (!queue.isEmpty() && !found) {
                int size = queue.size();

                for (int j = 0; j < size; j++) {
                    Node now = queue.poll();

                    for (int k = 0; k < 8; k++) {
                        int nextX = now.x + dx[k];
                        int nextY = now.y + dy[k];

                        // 다음 좌표가 체스판 범위를 벗어나면 무시
                        if (nextX < 0 || nextY < 0 || nextX >= l || nextY >= l) continue;

                        // 이미 방문한 좌표라면 무시
                        if (visited[nextX][nextY]) continue;

                        // 도착지에 도달한 경우
                        if (nextX == endX && nextY == endY) {
                            System.out.println(moveCount + 1); // 현재 레벨에서 한 번 더 이동했으므로 moveCount + 1 출력
                            found = true; // 도착지 도달 플래그 설정
                            break; // 현재 방향 탐색 루프 종료
                        }

                        visited[nextX][nextY] = true;
                        queue.add(new Node(nextX, nextY));
                    }

                    // 도착지에 도달했다면, 현재 레벨 탐색 종료
                    if (found) break; // found가 true면 더 이상 현재 레벨의 다른 노드를 탐색하지 않음
                }

                // 현재 레벨의 모든 노드 처리가 끝났으므로 이동 횟수 증가
                moveCount++; // 다음 레벨로 넘어가기 전 이동 횟수 1 증가
            }
        }
    }
}
