import java.util.Arrays;
import java.util.Collections;

class Solution {
  public static int[] solution(int[] arr) {
    // 1. 중복값 제거
    // 과정
    // Arrays.stream 메서드를 통해 stream으로 변환 ->
    // primitive 타입인 IntStream 데이터를 boxed를 통해 레퍼런스타입(Integer)로 변경 ->
    // distinct를 통해 중복을 제거 후 Integer 배열로 변경
    Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);

    // 2, 내림차순 정렬
    Arrays.sort(result, Collections.reverseOrder());

    // 3. int형 배열로 변경 후 반환
    return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
  }
}
