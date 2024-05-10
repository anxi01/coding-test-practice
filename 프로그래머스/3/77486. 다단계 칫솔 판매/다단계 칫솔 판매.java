import java.util.HashMap;
import java.util.Map;

class Solution {
  public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

    // relation 해시맵. key는 enroll의 노드, value는 referral의 노드로 구성
    Map<String, String> relation = new HashMap<>();
    for (int i = 0; i < enroll.length; i++) {
      relation.put(enroll[i], referral[i]);
    }

    // total 총합 해시맵 생성
    Map<String, Integer> total = new HashMap<>();

    // seller 배열과 amount 배열을 이용하여 이익 분배
    for (int i = 0; i < seller.length; i++) {
      String currentName = seller[i];

      // 판매자가 판매한 총 금액 계산
      int money = amount[i] * 100;

      // 판매자로부터 차례대로 상위 노드로 이동하며 이익 분배 (재귀)
      while (money > 0 && !currentName.equals("-")) {
        // 현재 판매자가 받을 금액 계산 (10%를 제외한 금액)
        total.put(currentName, total.getOrDefault(currentName, 0) + money - (money / 10));
        currentName = relation.get(currentName);
        money /= 10;
      }
    }

    // enroll 배열의 모든 노드에 해당하는 이익을 배열로 반환
    int[] answer = new int[enroll.length];
    for (int i = 0; i < enroll.length; i++) {
      answer[i] = total.getOrDefault(enroll[i], 0);
    }
    return answer;
  }
}