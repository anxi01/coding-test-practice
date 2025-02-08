import java.util.Arrays;

class Solution {
  public int solution(int[] citations) {
    Arrays.sort(citations);
    int n = citations.length;

    for (int i = 0; i < n; i++) {
      int h = n - i;  // h는 현재 논문 포함 남은 개수

      if (citations[i] >= h) {  // 현재 논문의 인용 횟수가 h 이상이면
        return h; // h-Index는 최대값이므로 바로 리턴한다.
      }
    }

    return 0;
  }
}
