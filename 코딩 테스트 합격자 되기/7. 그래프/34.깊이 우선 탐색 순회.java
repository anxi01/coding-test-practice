import java.util.ArrayList;
import java.util.Arrays;

/**
 * DFS (깊이우선탐색)
 * 풀이 과정
 * 1. 인접 리스트를 생성한다.
 *   - 인접 리스트는 List의 배열로 생성한다.
 *   - 인접 리스트 초기화는 전체 노드의 개수 + 1로 한다.
 *      - 1 ~ N까지 인덱스로 넣어주기 위해
 *   - 그래프의 출발, 도착 노드를 인접리스트에 넣어준다.
 *
 * 2. 방문 boolean 배열을 만든다. 인접리스트와 마찬가지로 노드 + 1까지 만든다.
 * 3. dfs 메서드를 통해 재귀적으로 호출한다.
 *   - 방문 배열에 추가
 *   - 결과에 넣기
 *   - 해당 노드의 인접 매열의 존재하고, 방문하지 않았다면 재귀적으로 호출한다.
 */
public class Main {

    private static ArrayList<Integer>[] adjList;

    private static boolean[] visited;
    private static ArrayList<Integer> result;

    private static int[] solution(int[][] graph, int start, int n) {

        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n + 1];
        result = new ArrayList<>();
        dfs(start);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int now) {
        visited[now] = true;
        result.add(now);

        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
