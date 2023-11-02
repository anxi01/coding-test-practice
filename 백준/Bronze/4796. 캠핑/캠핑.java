import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        while (true) {
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();
            if (L==0 && P ==0 && V ==0) break;
            count++;
            int X = 0;
            X = (V/P)*L;

            if (V%P <=L) {
                X += V%P;
            } else {
                X +=L;
            }
            System.out.println("Case " + count + ": " + X);
        }
    }
}