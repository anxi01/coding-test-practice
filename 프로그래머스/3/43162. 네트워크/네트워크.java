import java.io.*;
import java.util.*;

class Solution {
	
	private static int[][] computer;

	private static boolean[] visited; // 방문 배열 생성

	public int solution(int n, int[][] computers) {
		computer = computers; // shallow copy
		visited = new boolean[n];

		int answer = 0;

		// 모든 컴퓨터 순회
		for (int i = 0; i < n; i++) {

			// 방문하지 않은 경우에만 dfs 수행
			if (!visited[i]) {
				dfs(i);
				answer++;
			}
		}

		return answer;
	}

	private static void dfs(int now) {
		// 방문한 정점은 다시 돌지 않기
		if (visited[now]) {
			return;
		}

		visited[now] = true;

		for (int i = 0; i < computer.length; i++) {
			// 컴퓨터와 네트워크 연결이 되어있을 경우, dfs 수행
			if (computer[now][i] == 1) {
				dfs(i);
			}
		}
	}
}