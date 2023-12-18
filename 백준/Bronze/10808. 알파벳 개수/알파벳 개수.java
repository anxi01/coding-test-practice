import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();

        int[] alpha = new int[26];

        for (int i = 0; i < words.length(); i++) {
            alpha[words.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int num : alpha) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
