import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
  public static int[] solution(int[] progresses, int[] speeds) {

    Queue<Integer> queue = new ArrayDeque<>();

    int n = progresses.length;

    // 각 작업의 배포 가능일 계산
    int[] dayLeft = new int[n];
    for (int i = 0; i < n; i++) {
      // Math.ceil (올림) , Math.floor (내림)
      dayLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
    }

    int count = 0; // 배포될 작업의 수 카운트
    int maxDay = dayLeft[0]; // 현재 배포될 작업 중 가장 늦게 배포될 작업의 가능일

    for (int i = 0; i < n; i++) {
      // 배포 가능일이 가장 늦은 배포일보다 빠르면
      if (dayLeft[i] <= maxDay) {
        count++;
      } else {
        // 배포 예정일이 기준 배포일보다 느리면
        queue.add(count);
        count = 1;
        maxDay = dayLeft[i];
      }
    }

    queue.add(count); // 마지막으로 카운트된 작업들을 함께 배포
    return queue.stream().mapToInt(Integer::intValue).toArray();
  }
}
