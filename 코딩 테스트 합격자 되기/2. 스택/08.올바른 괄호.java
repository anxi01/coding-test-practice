// 정답 풀이
import java.util.ArrayDeque;

class Solution {
  static boolean solution(String s) {

    // 스택 대신 ArrayDeque를 사용하자.
    ArrayDeque<Character> stack = new ArrayDeque<>();

    char[] brackets = s.toCharArray();

    // 과정
    // 열린 괄호('(')일 경우는 stack에 push한다.
    // 닫힌 괄호(')')일 경우는 stack에 들어있는 열린 괄호를 제거한다.
    for (char bracket : brackets) {
      if (bracket == '(') {
        stack.push(bracket);
      } else {
        // 만약 닫힌 괄호일 때, 스택이 비어있거나 스택에 들어있는 값이 열린 괄호일 경우, false를 반환한다.
        // 스택이 비어있는지 먼저 체크하는 것이 중요하다. (스택에 값이 없을 수도 있기 때문)
        if (stack.isEmpty() || stack.pop() == bracket) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
