class Solution {
  public int solution(int n) {
    StringBuilder sb = new StringBuilder();

    // 10진번 -> 3진법
    while (n != 0) {
      sb.append(n % 3);
      n /= 3;
    }

    return Integer.parseInt(sb.toString(), 3);
  }
}