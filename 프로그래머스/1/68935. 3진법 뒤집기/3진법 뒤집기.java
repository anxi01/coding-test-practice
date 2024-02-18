class Solution {
  public int solution(int n) {
    StringBuilder sb = new StringBuilder();

    // 10진번 -> 3진법
    while (n != 0) {
      sb.append(n % 3);
      n /= 3;
    }
    String str = sb.toString();

    // 3진법 -> 10진법
    int answer = 0;
    for (int i = 0; i < str.length(); i++) {
      answer += (int) Math.pow(3, str.length() - 1 - i) * Character.getNumericValue(str.charAt(i));
    }
    return answer;
  }
}