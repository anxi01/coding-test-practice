import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    private static List<Node>[] adjList;

    private static class Node {
        int dest, weight;

        Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int solution(int N, int[][] road, int K) {
        adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        /**
         * 주의:
         * "양방향으로 통행할 수 있는 도로로 연결"
         * -> A마을에서 B마을로 갈 경우,
         * -> B마을에서 A마을로 갈 경우,
         * 총 2개의 경우가 존재함.
         *
         * 따라서 양방향을 인접리스트에 저장해야한다.
         */
        for (int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.weight, o2.weight)));
        dist[1] = 0;
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 우선순위 큐에서 꺼낸 노드의 가중치가 이미 기록된 최단 거리보다 클 경우
            if (dist[now.dest] < now.weight) {
                continue;
            }

            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] > now.weight + next.weight) {
                    dist[next.dest] = now.weight + next.weight;
                    queue.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}
