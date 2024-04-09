import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public static int[] solution(int[] progresses, int[] speeds) {

    ArrayDeque<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < progresses.length; i++) {
      int count = 0;
      while (progresses[i] < 100) {
        progresses[i] += speeds[i];
        count++;
      }
      queue.addLast(count);
    }

    ArrayList<Integer> temp = new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      int current = queue.pollFirst();
      temp.add(current);

      if (!queue.isEmpty() && current < queue.peekFirst()) {
        result.add(temp.size());
        temp = new ArrayList<>();
      }

      if (queue.isEmpty()) {
        result.add(temp.size());
      }
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
