import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        int count5 = n / 5;
        while (true) {
            int tmp = n;
            tmp -= count5 * 5;

            if (tmp % 2 == 0) {
                count += tmp / 2;
                count += count5;
                System.out.println(count);
                break;
            }else {
                count5--;
                if (count5 < 0) {
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}