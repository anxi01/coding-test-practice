import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] list = new int[N];

        for(int i = 0; i < N; i++){
            list[i] = sc.nextInt();
        }
        for (int i = 0; i < N-1; i++) {
            for (int j= i + 1; j < N; j++){
                if(list[i] > list[j]){
                    int tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                }
            }
        }
        for(int n : list){
            System.out.println(n);
        }
    }
}