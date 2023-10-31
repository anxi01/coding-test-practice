import java.util.*;

public class Main {
    public static void main(String[] args) {

        // PriorityQueue 사용
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            queue.add(sc.nextInt());
        }

        int result = 0;
        while(queue.size() != 1){
            int first = queue.poll(); // poll : 첫 번째 값 반환 후 제거
            int second = queue.poll();

            int sum = first + second;
            queue.add(sum);
            result += sum;
        }
        System.out.println(result);
    }
}
