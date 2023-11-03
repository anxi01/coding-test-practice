import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] set = new int[m];
        int[] unit = new int[m];

        for(int i = 0; i < m; i++){
            set[i] = sc.nextInt();
            unit[i] = sc.nextInt();
        }
        Arrays.sort(set);
        Arrays.sort(unit);

        int sum = 0;
        while(true){
            if(n >= 6){
                sum += Math.min((n / 6) * set[0],(n / 6) * 6 * unit[0]);
                n = n % 6;
            }else{
                sum += Math.min(set[0], n * unit[0]);
                break;
            }
        }
        System.out.println(sum);
    }
}