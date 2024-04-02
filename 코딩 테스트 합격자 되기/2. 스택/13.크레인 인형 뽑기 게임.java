import java.util.ArrayDeque;

class Solution {
  public static int solution(int[][] board, int[] moves) {

    int count = 0;
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < moves.length; i++) {

      for (int j = 0; j < board.length; j++) {
        int move = moves[i] - 1;

        if (board[j][move] != 0) {
          if (stack.isEmpty() || stack.peek() != board[j][move]) {
            stack.push(board[j][move]);
          } else {
            stack.pop();
            count++;
          }
          board[j][move] = 0;
          break;
        }
      }
    }
    return 2 * count;
  }
}
