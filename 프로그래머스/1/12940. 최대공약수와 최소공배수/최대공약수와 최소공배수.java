class Solution {
  public int[] solution(int n, int m) {
    int[] answer = new int[2];

    int gcd = 1;

    for (int i = 1; i <= Math.min(n, m); i++) {
      if (n % i == 0 && m % i == 0) {
        gcd = i;
      }
    }
    answer[0] = gcd;

    if (gcd != 1) {
      answer[1] = gcd * (n / gcd) * (m / gcd);
    } else {
      answer[1] = n * m;
    }

    return answer;
  }
}