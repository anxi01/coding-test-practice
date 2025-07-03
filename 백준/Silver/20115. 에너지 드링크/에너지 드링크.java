import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> drinks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            drinks.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(drinks);

        double sum = drinks.get(N - 1);
        for (int i = 0; i < N - 1; i++) {
            sum += (double) drinks.get(i) / 2;
        }

        System.out.print(sum);
    }
}
