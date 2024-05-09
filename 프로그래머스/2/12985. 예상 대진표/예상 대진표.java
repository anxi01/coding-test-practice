class Solution {
  public static int solution(int n, int a, int b) {
    int answer;

    /*
    a와 b의 index 번호가 같을 때 같은 라운드에서 봤다고 할 수 있다.
    
    n = 8, a = 4, b = 7일 때,
    첫 라운드에서 a는 4번 idx를, b는 7번 idx를 가진다.
    두 번째 라운드에선 a와 b는 만나기 전까지 계속 이기기때문에
    idx는 모두 1씩 더한 값에 나누기 2를 한 값이 된다.
    idx가 같아지는 순간에 반복문을 빠져나간다.
     */
    for (answer = 0; a != b; answer++) {
      a = (a + 1) / 2;
      b = (b + 1) / 2;
    }

    return answer;
  }
}