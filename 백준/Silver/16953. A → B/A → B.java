import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int count = 0;
        while(true) {
            if (b % 2 == 0 && b != 0) {
                b /= 2;
                count++;
            } else if (b % 10 == 1) {
                b /= 10;
                count++;
            } else {
                System.out.println(-1);
                break;
            }

            if (b == a) {
                System.out.println(count + 1);
                break;
            }
        }
    }
}
