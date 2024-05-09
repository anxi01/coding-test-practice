import java.util.Arrays;
import java.util.HashMap;

class Solution {
  public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    HashMap<String, String> relationMap = new HashMap<>();

    for (int i = 0; i < enroll.length; i++) {
      relationMap.put(enroll[i], referral[i]);
    }

    HashMap<String, Integer> sellerAmountMap = new HashMap<>();

    for (int i = 0; i < seller.length; i++) {
      sellerAmountMap.put(seller[i], amount[i]);
    }

    HashMap<String, Integer> resultMap = new HashMap<>();
    for (String s : enroll) {
      resultMap.put(s, 0);
    }

    for (String s : seller) {
      int price = sellerAmountMap.get(s) * 100;
      int remain = price / 10;
      resultMap.put(s, resultMap.getOrDefault(s, 0) + price - remain);

      recursion(relationMap, remain, resultMap, s);
    }

    int[] result = new int[enroll.length];
    for (int i = 0; i < enroll.length; i++) {
      result[i] = resultMap.get(enroll[i]);
    }
    return result;
  }

  private static void recursion(HashMap<String, String> relationMap, int remain,
      HashMap<String, Integer> resultMap, String seller) {
    String tmpReferral = relationMap.get(seller);
    if (tmpReferral.equals("-") || remain < 1) {
      return;
    }
    int subRemain = remain / 10;
    resultMap.put(tmpReferral, resultMap.getOrDefault(tmpReferral, 0) + remain - subRemain);
    recursion(relationMap, subRemain, resultMap, tmpReferral);
  }
}
