import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Character, Integer> dialMap = new HashMap<>();
    private static final int BASE_TIME = 2;
    private static final int TIME_PER_DIAL_STEP = 1;

    public static void main(String[] args) throws IOException {
        initializeDialMap();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();

        int totalTime = 0;
        for (char word : words) {
            int dialNumber = dialMap.get(word);
            int dialStep = dialNumber - 1;
            totalTime += BASE_TIME + TIME_PER_DIAL_STEP * dialStep;
        }

        System.out.print(totalTime);
    }

    private static void initializeDialMap() {
        dialMap.put('A', 2); dialMap.put('B', 2); dialMap.put('C', 2);
        dialMap.put('D', 3); dialMap.put('E', 3); dialMap.put('F', 3);
        dialMap.put('G', 4); dialMap.put('H', 4); dialMap.put('I', 4);
        dialMap.put('J', 5); dialMap.put('K', 5); dialMap.put('L', 5);
        dialMap.put('M', 6); dialMap.put('N', 6); dialMap.put('O', 6);
        dialMap.put('P', 7); dialMap.put('Q', 7); dialMap.put('R', 7); dialMap.put('S', 7);
        dialMap.put('T', 8); dialMap.put('U', 8); dialMap.put('V', 8);
        dialMap.put('W', 9); dialMap.put('X', 9); dialMap.put('Y', 9); dialMap.put('Z', 9);
    }
}
