import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        /**
         * 1. 스택에 원소를 삽입할 때는, 단순히 특정 수에 도달할 때까지 삽입
         * 2. 스택에서 원소를 연달아 빼낼 때 내림차순을 유지할 수 있는지 확인
         */

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 1;

        Stack<Integer> stack = new Stack<>();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            while (count <= num) {
                stack.push(count);
                count++;
                list.add('+');
            }
            if (stack.peek() == num) { // peek() : 스택의 맨 윗 값(가장 나중에 들어온 값)
                stack.pop();
                list.add('-');
            } else {
                System.out.println("NO");
                return;
            }
        }
        for(char c : list){
            System.out.println(c);
        }
    }
}