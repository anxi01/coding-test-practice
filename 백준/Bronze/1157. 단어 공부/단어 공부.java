import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().toUpperCase();
        int[] count = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - 'A';
            count[num]++;
        }

        int maxCount = 0;
        char answer = '?';
        for (int i = 0; i < count.length; i++) {
            if (maxCount < count[i]) {
                maxCount = count[i];
                answer = (char) ('A' + i);
            } else if (maxCount == count[i]) {
                answer = '?';
            }
        }

        System.out.print(answer);
    }
}