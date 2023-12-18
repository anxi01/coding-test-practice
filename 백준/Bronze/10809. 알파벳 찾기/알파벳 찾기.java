import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();

        int[] alpha = new int[26];

        Arrays.fill(alpha, -1);

        for (int i = 0; i < words.length(); i++) {
            if (alpha[words.charAt(i) - 'a'] == -1) {
                alpha[words.charAt(i) - 'a'] = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int num : alpha) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
