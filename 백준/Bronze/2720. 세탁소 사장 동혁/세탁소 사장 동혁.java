import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int cent = sc.nextInt();

            if(cent / 25 > 0){
                System.out.print(cent / 25 + " ");
                cent -= cent / 25 * 25;
            }else System.out.print(0 + " ");

            if(cent / 10 > 0){
                System.out.print(cent / 10 + " ");
                cent -= cent / 10 * 10;
            }else System.out.print(0 + " ");

            if(cent / 5 > 0){
                System.out.print(cent / 5 + " ");
                cent -= cent / 5 * 5;
            }else System.out.print(0 + " ");

            if(cent > 0){
                System.out.println(cent);
            }else System.out.println(0);
        }
    }
}