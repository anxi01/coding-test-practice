import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] list = new int[n];

        for(int i = 0; i < n; i++){
            list[i] = sc.nextInt();
        }
        for(int i = 0; i < n-1; i++){
            list[i+1] = (i+2) * list[i+1];
            for(int j = 0; j < i+1; j++){
                list[i+1] -= list[j];
            }
        }
        for(int k : list){
            System.out.print(k + " ");
        }
    }
}