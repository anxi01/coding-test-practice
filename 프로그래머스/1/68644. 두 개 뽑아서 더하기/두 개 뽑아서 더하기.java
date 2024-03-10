import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public static int[] solution(int[] numbers) {
    List<Integer> sumList = new ArrayList<>();

    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        int sum = numbers[i] + numbers[j];
        sumList.add(sum);
      }
    }

    int[] result = sumList.stream().distinct().mapToInt(Integer::intValue).toArray();
    Arrays.sort(result);

    return result;
  }
}