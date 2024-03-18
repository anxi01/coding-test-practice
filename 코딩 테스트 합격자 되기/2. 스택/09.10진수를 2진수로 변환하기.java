import java.util.Stack;

class Solution {

  /*
  ex) 13을 2진수로 바꾸기

  13 % 2 = 1
  6 % 2 = 0
  3 % 2 = 1
  1 % 2 = 1

  아래서부터 읽으므로 13의 2진수는 1101 이다.

  따라서 스택에 나머지 값을 순차적으로 push하고, 이후 아래부터 읽으므로 pop한 값을 붙여 반환하면 된다.
  */
  
  static String solution(int decimal) {
    Stack<Integer> stack = new Stack<>();

    while (decimal != 0) {
      int value = decimal % 2;
      stack.push(value);
      decimal /= 2;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.toString();
  }
}
