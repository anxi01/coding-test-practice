class Solution {
  public int solution(int[][] sizes) {

    // 지갑 길이
    int prevMax = 0;
    int prevMin = 0;

    for (int[] size : sizes) {
      // 명함의 최대 최소 길이
      int curMax = Math.max(size[0], size[1]);
      int curMin = Math.min(size[0], size[1]);

      prevMax = Math.max(curMax, prevMax);
      prevMin = Math.max(curMin, prevMin);
    }
    return prevMax * prevMin;
  }
}