import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] a = sc.next().split("");
        String[] b = sc.next().split("");

        StringBuffer sbA = new StringBuffer();
        StringBuffer sbB = new StringBuffer();
        int minA = 0;
        int maxA = 0;

        for(String aa : a){
            if(Objects.equals(aa, "6")){
                sbA.append("5");
            }else {
                sbA.append(aa);
            }
        }
        for(String bb : b){
            if(Objects.equals(bb, "6")){
                sbB.append("5");
            }else {
                sbB.append(bb);
            }
        }
        minA = Integer.parseInt(String.valueOf(sbA)) + Integer.parseInt(String.valueOf(sbB));

        sbA = new StringBuffer();
        sbB = new StringBuffer();
        for(String aa : a){
            if(Objects.equals(aa, "5")){
                sbA.append("6");
            }else {
                sbA.append(aa);
            }
        }
        for(String bb : b){
            if(Objects.equals(bb, "5")){
                sbB.append("6");
            }else {
                sbB.append(bb);
            }
        }
        maxA = Integer.parseInt(String.valueOf(sbA)) + Integer.parseInt(String.valueOf(sbB));

        System.out.println(minA + " " + maxA);
    }
}
