import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] scale = new int[8];
        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < 8; i++) {
            scale[i] = sc.nextInt();
        }
        for (int i = 0; i < 7; i++) {
            if(scale[i] > scale[i + 1]) ascending = false;
            if(scale[i] < scale[i + 1]) descending = false;
        }
        if(ascending)
            System.out.println("ascending");
        else if(descending)
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}