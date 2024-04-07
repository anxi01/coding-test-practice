import java.util.ArrayDeque;

class Solution {
  static int solution(int n, int k) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    // 1부터 n까지의 번호를 queue에 추가
    for (int i = 1; i <= n; i++) {
      queue.addLast(i);
    }
    
    // queue에 하나의 요소가 남을 때까지 반복
    while (queue.size() > 1) {
      // k번째 요소를 찾기 위해 앞에서부터 제거하고 뒤에 추가
      for (int i = 0; i < k - 1; i++) {
        queue.addLast(queue.pollFirst());
      }
      queue.pollFirst(); // k번째 요소 제거
    }

    return queue.pollFirst();
  }
}
