import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int range3 = n / 3;
        int range5 = n / 5;

        int[] list3 = new int[range3 + 1];
        int[] list5 = new int[range5 + 1];

        for(int i = 0; i <= range3; i++){
            list3[i] = i;
        }
        for(int j = 0; j <= range5; j++){
            list5[j] = j;
        }

        ArrayList<Integer> sum = new ArrayList<>();

        for(int i = 0; i <= range3; i++){
            for(int j = 0; j <= range5; j++){
                if((3 * list3[i]) + (5 * list5[j]) == n){
                    sum.add(i+j);
                }
            }
        }
        if(!sum.isEmpty()){
            Collections.sort(sum);
            System.out.println(sum.get(0));
        }else System.out.println(-1);
    }
}