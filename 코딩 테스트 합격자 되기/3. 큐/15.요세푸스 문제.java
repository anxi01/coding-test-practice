import java.util.ArrayDeque;

class Solution {
  static int solution(int n, int k) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    for (int i = 1; i <= n; i++) {
      queue.addLast(i);
    }

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < k - 1; j++) {
        if (!queue.isEmpty()) {
          queue.addLast(queue.pollFirst());
        }
      }
      queue.pollFirst();
    }

    return queue.pollFirst();
  }
}
