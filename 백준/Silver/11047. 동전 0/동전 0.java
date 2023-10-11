import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] changeTypes = new int[n];

        for(int i = 0; i < n; i++){
            changeTypes[i] = sc.nextInt();
        }

        int count = 0;

        for(int i = n-1; i >= 0; i--){
            if(k / changeTypes[i] > 0){
                count += (k / changeTypes[i]);
                k = k % changeTypes[i];
            }
        }
        System.out.println(count);
    }
}