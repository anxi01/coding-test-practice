import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
  public static int[] solution(int[] prices) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    int[] answer = new int[prices.length];

    for (int i = 0; i < prices.length; i++) {
      stack.push(prices[i]);

      for (int j = i + 1; j < prices.length; j++) {
        if (!stack.isEmpty() && stack.peek() <= prices[j]) {
          answer[i]++;
        }
      }
      stack.pop();
    }
    return answer;
  }
}
