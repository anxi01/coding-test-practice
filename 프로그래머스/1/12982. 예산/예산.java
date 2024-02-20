import java.util.Arrays;

class Solution {
  public int solution(int[] d, int budget) {
    Arrays.sort(d);

    int result = 0;
    for (int j : d) {
      if (j <= budget) {
        budget -= j;
        result++;
      } else break;
    }

    return result;
  }
}