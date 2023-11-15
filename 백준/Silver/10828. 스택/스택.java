import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();

            switch (s1){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!stack.empty())
                        sb.append(stack.pop()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.empty())
                        sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "top":
                    if(!stack.empty())
                        sb.append(stack.peek()).append("\n");
                    else sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}