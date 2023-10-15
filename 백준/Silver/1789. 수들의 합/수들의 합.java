import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long s = sc.nextLong();

        long n = 1;

        while(true){
            if (n * (n + 1) / 2 > s) {
                System.out.println(n - 1);
                break;
            } else n++;
        }
    }
}