import java.util.*;

class Solution {

    // 1. info 객체 생성
    /* info 객체는 
    - 현재 탐색 위치
    - 현재 탐색한 경로 기준 양의 수 (0)
    - 현재 탐색한 경로 기준 늑대의 수 (1)
    - 방문 노드 집합 (visited)
    로 존재한다.
    */
    private static class Info {
        int node, sheep, wolf;
        Set<Integer> visited;

        public Info(int node, int sheep, int wolf, Set<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }

    // 트리 구축
    private static List<Integer>[] tree;

    private static void createTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }

    public int solution(int[] info, int[][] edges) {
        createTree(info, edges); // 트리 생성
        int answer = 0; // 최대 양의 개수

        // BFS를 위한 큐 생성 및 초기 상태 설정
        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));

        // BFS : 큐의 원소가 없을 때까지 동작한다.
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            answer = Math.max(now.sheep, answer);
            now.visited.addAll(tree[now.node]);

            // 인접한 노드 탐색
            for (int next : now.visited) {
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);

                // 늑대일 경우
                if (info[next] == 1) {
                    if (now.sheep != now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                } else {
                    // 양일 경우
                    queue.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }
        return answer;
    }
}
