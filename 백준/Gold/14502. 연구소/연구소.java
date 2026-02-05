import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // row, column != x, y 좌표
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int N, M;
    static int[][] map;
    static ArrayDeque<Node> viruses = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;

                // Virus 위치
                if (x == 2) {
                    viruses.addLast(new Node(i, j));
                }
            }
        }

        // 벽 세우기 (3개)
        // N * M 크기의 2차원 배열을 1차원 인덱스(0 ~ N*M-1)로 변환하여 조회
        // i / M : 현재 인덱스를 가로 길이로 나눈 '몫' -> 행(c) 번호
        // i % M : 현재 인덱스를 가로 길이로 나눈 '나머지' -> 열(r) 번호
        /*
          [예시] N(세로)=2, M(가로)=5 일 때, 인덱스 7은?
          - 행(Row): 7 / 5 = 1 (1번째 줄)
          - 열(Col): 7 % 5 = 2 (2번째 칸) -> 좌표 (1, 2)
        */
        ArrayDeque<Node> blocks = new ArrayDeque<>();
        int answer = 0;
        for (int i = 0; i < N * M - 2; i++) {
            if (map[i / M][i % M] != 0) continue;
            blocks.addLast(new Node(i / M, i % M));
            for (int j = i + 1; j < N * M - 1; j++) {
                if (map[j / M][j % M] != 0) continue;
                blocks.addLast(new Node(j / M, j % M));
                for (int k = j + 1; k < N * M; k++) {
                    if (map[k / M][k % M] != 0) continue;
                    blocks.addLast(new Node(k / M, k % M));
                    answer = Math.max(answer, bfs(blocks));
                    blocks.pollLast();
                }
                blocks.pollLast();
            }
            blocks.pollLast();
        }

        System.out.println(answer);
    }

    private static int bfs(ArrayDeque<Node> blocks) {
        // Deep Copy
        int[][] mapCopy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mapCopy[i][j] = map[i][j];
            }
        }
        for (Node block : blocks) {
            mapCopy[block.r][block.c] = 1;
        }

        // Virus Copy
        ArrayDeque<Node> virusesCopy = new ArrayDeque<>(viruses);
        while (!virusesCopy.isEmpty()) {
            Node virus = virusesCopy.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = virus.r + dr[i];
                int nc = virus.c + dc[i];

                // 경로 벗어남
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                // 빈 칸(0)일 때만 이동 가능
                if (mapCopy[nr][nc] != 0) {
                    continue;
                }

                virusesCopy.addLast(new Node(nr, nc));
                mapCopy[nr][nc] = 2;
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mapCopy[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
