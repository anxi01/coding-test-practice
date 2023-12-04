import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            StringBuilder sb = new StringBuilder();

            switch (command) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (deque.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(deque.pollFirst());
                    System.out.println(sb);
                    break;
                case "pop_back":
                    if (deque.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(deque.pollLast());
                    System.out.println(sb);
                    break;
                case "size":
                    sb.append(deque.size());
                    System.out.println(sb);
                    break;
                case "empty":
                    if (deque.isEmpty())
                        sb.append(1);
                    else sb.append(0);
                    System.out.println(sb);
                    break;
                case "front":
                    if (deque.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(deque.peekFirst());
                    System.out.println(sb);
                    break;
                case "back":
                    if (deque.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(deque.peekLast());
                    System.out.println(sb);
            }
        }
    }
}
