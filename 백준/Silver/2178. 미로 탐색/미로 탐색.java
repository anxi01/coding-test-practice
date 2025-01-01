import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    private static final int[] rx = {1, -1, 0, 0};
    private static final int[] ry = {0, 0, 1, -1};

    private static class Node {
        int row, col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            maze[i] = br.readLine().toCharArray();
        }

        int[][] dist = new int[n][m];
        dist[0][0] = 1;

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + rx[i];
                int nextCol = now.col + ry[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                    continue;
                }

                if (maze[nextRow][nextCol] == '0') {
                    continue;
                }

                if (now.row == m - 1 && now.col == n - 1) {
                    break;
                }

                if (dist[nextRow][nextCol] == 0) {
                    dist[nextRow][nextCol] = dist[now.row][now.col] + 1;
                    queue.add(new Node(nextRow, nextCol));
                }
            }
        }

        System.out.println(dist[n - 1][m - 1]);
    }
}
