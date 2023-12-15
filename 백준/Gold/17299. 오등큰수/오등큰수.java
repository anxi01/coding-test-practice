import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] frequency = new int[1000001];
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열 배열(seq)와 등장 횟수(frequency)를 입력한다.
        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(st.nextToken());
            seq[i] = element;
            frequency[element]++;
        }

        Stack<Integer> stack = new Stack<>();

        // 17298 오큰수와 유사 로직
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && frequency[seq[stack.peek()]] < frequency[seq[i]]) {
                seq[stack.pop()] = seq[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for (int k : seq) {
            sb.append(k).append(" ");
        }

        System.out.println(sb);
    }
}
