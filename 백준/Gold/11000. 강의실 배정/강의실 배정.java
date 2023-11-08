import java.lang.reflect.Array;
import java.util.*;

class Node implements Comparable<Node> {
    int start;
    int end;

    public Node(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public int compareTo(Node o) {
        // 시작시간을 기준으로 오름차순 정렬
        // 만약 시작시간이 같다면 끝나는 시간을 기준으로 오름차순 정렬
        if (start == o.start) {
            return end - o.end;
        }
        return start - o.start;
    }
}
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(nodes);

        // 끝나는 시간이 제일 작은 것부터
        // 다음의 시작 시간과 비교하므로 우선순위 큐를 이용한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 초기값 : 첫 번째의 끝나는 시작값
        pq.offer(nodes[0].end);

        for (int i = 1; i < n; i++) {
            // 만약 이전 수업의 끝나는 시간이 현재 수업의 시작 시간보다 작다면
            // 이전 수업을 빼준다.
            if (nodes[i].start >= pq.peek()) {
                pq.poll();
            }
            // 조건과 무관하게 현재 수업의 끝나는 시간을 넣는다.
            pq.offer(nodes[i].end);
        }
        // 남아있는 pq의 사이즈가 강의실의 개수이다.
        System.out.println(pq.size());
    }
}
