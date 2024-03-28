import java.util.Arrays;

class Solution {
  public static int[] solution(int[] prices) {

    int[] answer = new int[prices.length];

    // O(N^2)
    // 입력값 : 100,000
    // 총 10,000,000,000 (100억)
    // 만약 1억에 1초라고 가정하면 100초가 걸림
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        answer[i]++;
        if (prices[i] > prices[j]) {
          break;
        }
      }
    }
    return answer;
  }
}