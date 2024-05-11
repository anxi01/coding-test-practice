import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    // 최상위 노드 (A부터 시작하므로)
    Node head = new Node('A', null, null);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      char root = st.nextToken().charAt(0);
      char left = st.nextToken().charAt(0);
      char right = st.nextToken().charAt(0);

      createNode(head, root, left, right); // 노드 생성
    }

    preOrder(head);
    System.out.println();
    inOrder(head);
    System.out.println();
    postOrder(head);
    System.out.println();
  }

  private static void createNode(Node head, char root, char left, char right) {
    if (head.value == root) {
      head.left = (left == '.' ? null : new Node(left, null, null));
      head.right = (right == '.' ? null : new Node(right, null, null));
    } else {
      if (head.left != null) {
        createNode(head.left, root, left, right);
      }
      if (head.right != null) {
        createNode(head.right, root, left, right);
      }
    }
  }

  static class Node {
    char value;
    Node left, right;

    Node(char value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }

  private static void preOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.print(node.value);
    preOrder(node.left);
    preOrder(node.right);
  }

  private static void inOrder(Node node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    System.out.print(node.value);
    inOrder(node.right);
  }

  private static void postOrder(Node node) {
    if (node == null) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.value);
  }
}