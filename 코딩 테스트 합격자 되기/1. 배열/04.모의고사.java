// 답안 풀이
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public static int[] solution(int[] answers) {

    // 수포자들의 패턴
    int[][] pattern = {
        {1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    // 수포자들의 점수를 저장할 배열
    int[] scores = new int[3];

    // 각 수포자들의 패턴과 정답이 얼마나 일치하는지 확인
    for (int i = 0; i < answers.length; i++) {
      for (int j = 0; j < pattern.length; j++) {
        if (answers[i] == pattern[j][i % pattern[j].length]) {
          scores[j]++;
        }
      }
    }

    // 가장 높은 점수 저장
    int maxScore = Arrays.stream(scores).max().getAsInt();

    // 가장 높은 점수를 가진 수포자들의 번호를 찾아서 리스트에 담음
    List<Integer> answer = new ArrayList<>();
    for (int i = 0; i < scores.length; i++) {
      if (scores[i] == maxScore) {
        answer.add(i + 1);
      }
    }
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}

/*
// 기존 풀이
class Solution {
  public static int[] solution(int[] answers) {
    int count1 = 0, count2 = 0, count3 = 0;

    int[] number1 = {1, 2, 3, 4, 5};
    int[] number2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] number3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == number1[i % 5]) {
        count1++;
      }
      if (answers[i] == number2[i % 8]) {
        count2++;
      }
      if (answers[i] == number3[i % 10]) {
        count3++;
      }
    }
    
    // count1, 2, 3 의 크기 비교를 하지 못함.
  }
}
*/
