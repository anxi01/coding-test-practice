import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
  public static int[] solution(int[] progresses, int[] speeds) {

    ArrayDeque<Integer> queue = new ArrayDeque<>();

    while (queue.size() != progresses.length) {
      for (int i = 0; i < progresses.length; i++) {
        progresses[i] += speeds[i];
        if (progresses[i] >= 100) {
          queue.addLast(i);
          progresses[i] = 0;
          speeds[i] = 0;
        }
      }
    }

    int val = 0;
    ArrayList<Integer> result = new ArrayList<>();

    int count = 0;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      count++;

      if (current == val) {
        result.add(count);
        val = count;
        count = 0;
      }
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}