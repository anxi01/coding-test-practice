import java.util.ArrayDeque;

class Solution {
  public static int[] solution(int[] prices) {
    int n = prices.length;
    int[] answer = new int[n]; // 가격이 떨어지지 않은 기간을 저장할 배열

    // 스택을 사용해 이전 가격과 현재 가격 비교
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    stack.push(0); // 0번째 index 먼저 집어넣음 -> 비교 기준 값

    // O(N)
    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
        // 이전 가격보다 현재 가격이 낮을 때 (즉 가격이 떨어졌을 떄)
        // 이전 가격의 기간 계산
        int j = stack.pop();
        answer[j] = i - j;
      }
      stack.push(i);
    }

    // 스택에 끝까지 남은 index는
    // 가장 끝의 index(n-1)에서 현재 index(j) 값을 빼서 구한다.
    while (!stack.isEmpty()) {
      int j = stack.pop();
      answer[j] = n - 1 - j;
    }
    return answer;
  }
}
