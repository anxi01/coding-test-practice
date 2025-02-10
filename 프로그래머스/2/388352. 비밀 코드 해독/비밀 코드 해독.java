import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {

    List<Set<Integer>> candidates = new ArrayList<>();
    combination(1, n, 5, new ArrayList<>(), candidates);

    int answer = 0;

    for (Set<Integer> candidate : candidates) {
      if (isValid(candidate, q, ans)) {
        answer++;
      }
    }

    return answer;
  }

  // backtrack
  private void combination(int start, int n, int r, List<Integer> current, List<Set<Integer>> result) {
    // r개의 조합을 만들었을 경우.
    if (current.size() == r) {
      result.add(new HashSet<>(current));
      return;
    }

    for (int i = start; i <= n; i++) {
      current.add(i);
      combination(i + 1, n, r, current, result);
      current.remove(current.size() - 1);
    }
  }

  // 조건 검증
  private boolean isValid(Set<Integer> candidate, int[][] q, int[] ans) {
    for (int i = 0; i < q.length; i++) {
      int count = 0;
      for (int num : q[i]) {
        if (candidate.contains(num)) {
          count++;
        }
      }
      if (count != ans[i]) {
        return false;
      }
    }
    return true;
  }
}