import java.util.HashMap;

class Solution {
  public static int solution(String[] want, int[] number, String[] discount) {

    // want에 담겨있는 map을 만든다.
    HashMap<String, Integer> wantMap = new HashMap<>();

    // wantMap에 원하는 제품의 수량을 값으로 하여 넣는다.
    for (int i = 0; i < want.length; i++) {
      wantMap.put(want[i], number[i]);
    }

    int answer = 0;

    // i는 discount가 시작할 날짜
    // 10일 연속 존재해야하므로 discount.length - i > 9 이어야 한다.
    // (discount.length - 1) - i > 10 이어야 한다. (i는 0부터, discount.length는 1부터 인덱스가 시작하므로)
    for (int i = 0; i < discount.length - 9; i++) {

      // wantMap과 비교할 discountMap
      HashMap<String, Integer> discountMap = new HashMap<>();

      for (int j = i; j < i + 10; j++) {
        // wantMap에 discount 값이 key로 존재하면 현재 값에 1씩 더해준다.
        if (wantMap.containsKey(discount[j])) {
          discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
        }
      }

      // discountMap이 wantMap과 같을 경우 answer를 1씩 증가한다.
      // equals 메서드는 해시맵 내 모든 키-값 쌍이 같아야 true를 반환한다.
      if (discountMap.equals(wantMap)) {
        answer++;
      }
    }

    return answer;
  }
}
