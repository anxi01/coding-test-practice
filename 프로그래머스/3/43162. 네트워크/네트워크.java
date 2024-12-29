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
