import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  public String solution(int[] numbers) {

    // 1. 정수를 문자열로 변환하여 리스트에 저장
    List<String> data = new ArrayList<>();
    for (int number : numbers) {
      data.add(String.valueOf(number));
    }

    // 2. 두 숫자를 조합한 값을 비교하여 정렬 (내림차순)
    //    o1 + o2와 o2 + o1을 비교하여 더 큰 순서대로 정렬
    Collections.sort(data, (o1, o2) -> {
      int a = Integer.parseInt(o1 + o2); // ex) "3" + "30" -> 330
      int b = Integer.parseInt(o2 + o1); // ex) "30" + "3" -> 303
      return Integer.compare(b, a); // 내림차순 정렬
    });

    // 3. 정렬된 문자열을 하나로 합침
    StringBuilder sb = new StringBuilder();
    for (String s : data) {
      sb.append(s);
    }

    // 4. 모든 값이 "0"일 경우 "0"을 반환 (ex: [0, 0, 0] -> "000" 대신 "0")
    if (sb.charAt(0) == '0') {
      return "0";
    }

    // 5. 최종 문자열 반환
    return sb.toString();
  }
}
