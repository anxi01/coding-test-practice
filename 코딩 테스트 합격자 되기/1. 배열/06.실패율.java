// 기존 코드
class Solution {
  public static int[] solution(int N, int[] stages) {
    double[] answer = new double[N];
    int[] result = new int[N];

    for (int i = 1; i <= N; i++) {
      // 분자
      int numerator = 0;
      // 분모
      int denominator = 0;

      for (int stage : stages) {
        if (stage >= i) {
          denominator++;

          if (stage == i) {
            numerator++;
          }
        }
      }
      answer[i - 1] = ((double) numerator / denominator);
    }

    Double[] clone = Arrays.stream(answer).boxed().toArray(Double[]::new);
    Arrays.sort(clone, Collections.reverseOrder());

    for (int i = 0; i < clone.length; i++) {
      for (int j = 0; j < answer.length; j++) {
        if (clone[i] == answer[j]) {
          result[i] = j + 1;
          break;
        }
      }
    }
    return result;
  }
}
// 결과 : [3, 3, 2, 1, 5], 정답 : [3,4,2,1,5]
