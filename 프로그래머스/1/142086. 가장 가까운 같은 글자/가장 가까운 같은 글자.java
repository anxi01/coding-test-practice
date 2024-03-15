import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public static int[] solution(String s) {
    int[] alpha = new int[26];
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (alpha[c - 'a'] == 0) {
        alpha[c - 'a'] = -1;
      } else {
        for (int j = i - 1; j >= 0; j--) {
          if (c == s.charAt(j)) {
            alpha[c - 'a'] = i - j;
            break;
          }
        }
      }
      result.add(alpha[c - 'a']);
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}