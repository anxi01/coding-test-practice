import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int inp = sc.nextInt();

        for(int i = 0; i < inp; i++){
            int inp2 = sc.nextInt();
            String inpStr = sc.next();
            for(int j = 0; j < inpStr.length(); j++){
                for(int k=0; k < inp2; k++){
                    System.out.print(inpStr.charAt(j) + "");
                }
            }
            System.out.println();
        }
    }
}