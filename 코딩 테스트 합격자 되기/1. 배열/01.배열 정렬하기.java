import java.util.Arrays;

class Solution {
  public static int[] solution(int[] arr) {
    // 1. 원본배열(arr)이 같이 수정되는 경우
    Arrays.sort(arr);
    return arr;

    // 2. 원본 배열을 보존해야할 경우
    int[] clone = arr.clone();
    Arrays.sort(clone);
    return clone;
  }
}
