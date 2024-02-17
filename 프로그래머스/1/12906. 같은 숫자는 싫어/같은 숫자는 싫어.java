import java.util.*;

class Solution {
  public int[] solution(int []arr) {

    List<Integer> data = new ArrayList<>();

    int value = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != value) {
        data.add(arr[i]);
        value = arr[i];
      }
    }
    return data.stream().mapToInt(s -> s).toArray();
  }
}