// 답안 풀이
import java.util.Arrays;

class Solution {
  public static int[][] solution(int[][] arr1, int[][] arr2) {

    // TIP. 행렬의 곱
    // r1 x c1, r2 x c2
    // => 곱한 행렬은 r1 x c2의 행렬 구조로 변경된다.
    
    // 행렬 arr1과 arr2의 행과 열의 수
    int r1 = arr1.length;
    int c1 = arr1[0].length;
    int r2 = arr2.length;
    int c2 = arr2[0].length;

    // 결과를 저장할 2차원 배열 초기화
    int[][] answer = new int[r1][c2];

    // 첫 번째 행렬 arr1의 각 행과 두 번째 행렬 arr2의 각 열에 대해
    for (int i = 0; i < r1; i++) {
      for (int j = 0; j < c2; j++) {

        // 두 행렬의 데이터를 곱해 결과 리스트에 더하기
        for (int k = 0; k < c1; k++) {
          answer[i][j] += arr1[i][k] * arr2[k][j];
        }
      }
    }

    return answer;
  }
}

/*
// 기존 풀이
class Solution {
  public static int[][] solution(int[][] arr1, int[][] arr2) {

    int[][] answer = new int[arr1.length][arr1[0].length];

    for (int i = 0; i < arr1.length; i++) {
      int sum = 0;
      for (int j = 0; j < arr1[0].length; j++) {
        for (int k = 0; k < arr2[0].length; k++) {
          sum += arr1[i][j] * arr2[k][i];
        }
        answer[i][j] = sum;
      }
    }
    return answer;
  }
}
*/
