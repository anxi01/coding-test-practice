import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int startIdx = 0;
        int endIdx = word.length() - 1;

        while (startIdx <= endIdx) {
            if (word.charAt(startIdx) != word.charAt(endIdx)) {
                System.out.println(0);
                return;
            }
            startIdx++;
            endIdx--;
        }
        System.out.println(1);
    }
}
