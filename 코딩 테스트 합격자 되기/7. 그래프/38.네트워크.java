/**
 * 네트워크 문제 풀이
 * - 컴퓨터 간 연결 상태를 그래프로 표현
 * - 연결된 모든 노드를 한 번에 탐색하여 네트워크의 개수를 구함
 *
 * 풀이 과정:
 * 1. 모든 컴퓨터를 방문하며, 방문하지 않은 컴퓨터에서 DFS 탐색 시작
 * 2. DFS를 통해 연결된 모든 컴퓨터를 방문 처리
 * 3. DFS 호출 횟수 = 네트워크의 개수
 *
 * 시간 복잡도 : O(N^2)
 */
class Solution {

    private static boolean[] visited;

    private static int[][] computer;

    private static void dfs(int now) {
        visited[now] = true;
        for (int i = 0; i < computer[now].length; i++) {
            if (computer[now][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        computer = computers;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}
