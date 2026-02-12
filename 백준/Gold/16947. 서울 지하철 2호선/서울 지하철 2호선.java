import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int vertex, count;

        Node(int v, int c) {
            vertex = v;
            count = c;
        }
    }

    private static int N;
    private static List<Integer>[] subways;
    private static boolean[] isCycle;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        subways = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            subways[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int station1 = Integer.parseInt(st.nextToken());
            int station2 = Integer.parseInt(st.nextToken());

            subways[station1].add(station2);
            subways[station2].add(station1);
        }

        // DFS: 사이클 발생 정점 구하기
        isCycle = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (dfs(i, i, i)) {
                break;
            }
            isCycle = new boolean[N + 1];
        }

        // BFS: 사이클과 정점 사이의 최단 거리 구하기
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            // 사이클이 아닌 정점만 BFS 탐색
            if(!isCycle[i]) {
                result[i] = bfs(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static boolean dfs(int prev, int now, int start) {
        isCycle[now] = true;

        for (int next : subways[now]) {
            // 사이클 확인 되지 않은 경우, DFS 탐색
            if (!isCycle[next]) {
                if (dfs(now, next, start)) {
                    return true;
                }
            }
            // 이미 방문했던 노드(next)가 시작점(start)이면서,
            // 그 노드가 방금 내가 올라온 부모 노드(prev)가 아니라면 → 진짜 사이클
            else if (prev != next && next == start) {
                return true;
            }
        }
        isCycle[now] = false;

        return false;
    }

    private static int bfs(int vertex) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(new Node(vertex, 0));

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            // 사이클과 만나면 바로 반환
            if (isCycle[now.vertex]) {
                return now.count;
            }

            for (int next : subways[now.vertex]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.addLast(new Node(next, now.count + 1));
                }
            }
        }
        return 0;
    }
}
