import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt();

        if(hour == 0 && min >= 45){
            System.out.println(hour + " " + (min - 45));
        } else if (hour == 0 && min < 45) { 
            System.out.println((hour + 23) + " " + (min + 15));
        } else if (hour == 1 && min >= 45) {
            System.out.println(hour + " " + (min - 45));
        } else if (hour == 1 && min < 45) {
            System.out.println((hour - 1) + " " + (min + 15));
        } else if (hour > 1 && min >= 45) {
            System.out.println(hour + " " + (min - 45));
        } else
            System.out.println((hour - 1) + " " + (min + 15));
    }
}
