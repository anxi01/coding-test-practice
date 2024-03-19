import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
  public static int solution(String s) {

    // 괄호 정보를 맵에 저장한다.
    HashMap<Character, Character> map = new HashMap<>();

    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
    
    int n = s.length(); // 원본 문자열의 길이를 저장한다.
    s += s; // 문자열 회전을 위해 문자열을 이어 붙인다.
    int answer = 0;

    // 확인할 문자열을 0부터 n까지 이동
    A:
    for (int i = 0; i < n; i++) {
      ArrayDeque<Character> stack = new ArrayDeque<>();

      // i(시작 위치)부터 원본 문자열의 길이(n)개까지 올바른 괄호 문자열인지 확인한다.
      for (int j = i; j < i + n; j++) {
        char c = s.charAt(j);

        // 해시맵 안에 해당 키가 없다면 열린 괄호이다.
        // 따라서 열린 괄호는 스택에 넣어준다.
        if (!map.containsKey(c)) {
          stack.push(c);
        } else {
          // 괄호 짝이 맞지 않다면 내부 for문은 종료하고 for문 A로 이동한다.
          if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
            continue A;
          }
        }
      }
      
      // continue되지 않았고 스택이 다 비어졌으면 올바른 괄호 문자열이다.
      if (stack.isEmpty()) {
        answer++;
      }
    }
    return answer;
  }
}