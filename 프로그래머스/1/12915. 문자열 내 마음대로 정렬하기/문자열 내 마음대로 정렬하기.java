import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
      Arrays.sort(strings, ((o1, o2) -> {
        if (o1.charAt(n) < o2.charAt(n)) {
          return -1;
        } else if (o1.charAt(n) > o2.charAt(n)) {
          return 1;
        } else {
          // 같을 경우에 사전순으로 오름차순
          return o1.compareTo(o2);
        }
      }));

      return strings;
    }
}