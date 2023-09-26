import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = 0;

        int[] cards = new int[N];
        for(int i = 0; i < N; i++){
            cards[i] = sc.nextInt();
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(i!=j && j!=k && i!=k) {
                        int sum = cards[i] + cards[j] + cards[k];
                        if (sum <= M)
                            result = Math.max(sum, result);
                    }
                }
            }
        }
        System.out.println(result);
    }
}