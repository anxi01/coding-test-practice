import java.util.Arrays;

class Solution {
  public static String[] solution(int[] nodes) {
    String[] result = new String[3];
    result[0] = preOrder(nodes, 0).trim();
    result[1] = inOrder(nodes, 0).trim();
    result[2] = postOrder(nodes, 0).trim();

    return result;
  }

  // 전위 순회 : Root -> Left -> Right
  private static String preOrder(int[] nodes, int idx) {
    // idx(노드 번호)가 0부터 시작하므로, nodes 길이보다 같거나 커지면 빈 문자열 반환
    if (idx >= nodes.length) {
      return "";
    }

    return nodes[idx] + " " +
            preOrder(nodes, 2 * idx + 1) +
            preOrder(nodes, 2 * idx + 2);
  }

  // 중위 순회 : Left -> Root -> Right
  private static String inOrder(int[] nodes, int idx) {
    if (idx >= nodes.length) {
      return "";
    }

    return inOrder(nodes, 2 * idx + 1) +
            nodes[idx] + " " +
            inOrder(nodes, 2 * idx + 2);
  }

  // 후위 순회 : Left -> Right -> Root
  private static String postOrder(int[] nodes, int idx) {
    if (idx >= nodes.length) {
      return "";
    }

    return postOrder(nodes, 2 * idx + 1) +
            postOrder(nodes, 2 * idx + 2) +
            nodes[idx] + " ";
  }
}
public class Main {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(Solution.solution(new int[]{1, 2, 3, 4, 5, 6, 7})));
  }
}
