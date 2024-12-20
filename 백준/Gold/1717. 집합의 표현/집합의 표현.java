import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        parent[rootB] = rootA;
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (operation == 0) {
                union(parent, a, b);
            } else {
                if (find(parent, a) == find(parent, b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
}
