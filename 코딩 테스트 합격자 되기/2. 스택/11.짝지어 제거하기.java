import java.util.ArrayDeque;

// 정답코드
class Solution {
  public static int solution(String s) {

    ArrayDeque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {

      char c = s.charAt(i);

      // 스택이 비어 있지 않고, 현재 문자와 스택의 맨 위 문자가 같으면
      if (!stack.isEmpty() && stack.peek() == c) { 
        stack.pop(); // 스택의 맨 위 문자 제거
      } else {
        stack.push(c); // 스택에 현재 문자 추가
      }
    }
    return stack.isEmpty() ? 1 : 0; // 스택이 비어있으면 1 그렇지 않으면 0
  }
}

/*
// 실패코드
class Solution {
  public static int solution(String s) {

    ArrayDeque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {

      char c = s.charAt(i);

      // 스택에 문자가 없으면 넣는다.
      if (!stack.contains(c)) {
        stack.push(c);
      } else {
        // 스택에 겹치는 문자가 존재할 경우, 스택에서 빼낸 값과 현재 문자가 다르면 0을 반환한다.
        if (!stack.pop().equals(c)) {
          return 0;
        }
      }
    }
    
    // 이후 반복문이 끝나고 스택이 비어있으면 1을 반환(성공), 그렇지 않으면 0을 반환한다.(실패)
    if (stack.isEmpty()) {
      return 1;
    } else {
      return 0;
    }
  }
}
*/
