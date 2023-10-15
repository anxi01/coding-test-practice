import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] times = new int[3];

        if (n / 300 > 0){
            times[0] = n / 300;
            n = n - ((n / 300) * 300);
        }
        if (n / 60 > 0) {
            times[1] = n / 60;
            n = n - ((n / 60) * 60);
        }
        if (n / 10 > 0) {
            times[2] = n / 10;
            n = n - ((n / 10) * 10);
        }
        if(n == 0)
            System.out.println(times[0] + " " + times[1] + " " + times[2]);
        else System.out.println(-1);
    }
}