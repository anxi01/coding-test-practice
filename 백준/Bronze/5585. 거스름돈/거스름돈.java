import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int change = 1000 - n;
        int count = 0;

        while(change > 0){
            if(change / 500 > 0){
                count += (change / 500);
                change -= (change / 500) * 500;
            }else if (change / 100 > 0) {
                count += (change / 100);
                change -= (change / 100) * 100;
            }else if (change / 50 > 0){
                count += (change / 50);
                change -= (change / 50) * 50;
            }else if (change / 10 > 0){
                count += (change / 10);
                change -= (change / 10) * 10;
            }else if (change / 5 > 0){
                count += (change / 5);
                change -= (change / 5) * 5;
            }else{
                count += change;
                break;
            }
        }
        System.out.println(count);
    }
}