import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();

        int[] data = new int[n];

        for(int i = 0; i < n; i++){
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);

        int count = 0;
        double range = data[0] - 0.5 + l;
        count++;

        for (int i = 1; i < n; i++) {
            if (range < data[i] + 0.5) {
                range = data[i] - 0.5 + l;
                count++;
            }
        }
        System.out.println(count);
    }
}