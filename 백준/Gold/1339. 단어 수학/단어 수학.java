import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] alpha = new int[26];

        for(int i = 0; i < n; i++){
            String data = sc.next();
            for(int j = 0; j < data.length(); j++){
                char d = data.charAt(j);
                alpha[d - 'A'] += (int) Math.pow(10, data.length() - 1 - j);
            }
        }

        Arrays.sort(alpha);

        int num = 9;
        int idx = 25;
        int result = 0;
        while (alpha[idx] != 0) {
            result += alpha[idx] * num;
            idx--;
            num--;
        }
        System.out.println(result);
    }
}
