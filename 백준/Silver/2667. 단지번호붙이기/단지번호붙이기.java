import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    
    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] maps = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                maps[i][j] = line.charAt(j) - '0'; // 문자 '0' or '1'를 int로 변환
            }
        }

        List<Integer> complexSizes = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {            
            for (int j = 0; j < N; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    int count = 1;

                    ArrayDeque<Node> queue = new ArrayDeque<>();
                    queue.add(new Node(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Node now = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nextX = now.x + dx[k];
                            int nextY = now.y + dy[k];

                            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                                continue;

                            if (maps[nextX][nextY] == 0) 
                                continue;

                            if (visited[nextX][nextY]) 
                                continue;

                            queue.add(new Node(nextX, nextY));
                            visited[nextX][nextY] = true;
                            count++;
                        }
                    }

                    complexSizes.add(count);
                }
            }
        }

        Collections.sort(complexSizes);

        StringBuilder sb = new StringBuilder();
        sb.append(complexSizes.size()).append("\n");

        for (int complexSize : complexSizes) {
            sb.append(complexSize).append("\n");
        }

        System.out.println(sb);
    }
}
