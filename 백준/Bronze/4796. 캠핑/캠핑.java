import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 0;

        while(true){

            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();

            if(L == 0 && P == 0 && V == 0) break;

            // ex) 1 20 39
            // 최대 1일 + 남는 19일 + 최대 1일 + 남는 19일(over) => 1 + 1

            // ex) 5 8 20
            // 최대 5일 + 남는 3일 + 최대 5일 + 남는 3일 + 최대 4일 => 5 + 5 + 4
            int sum = 0;
            sum = (V / P) * L;
            count++;

            if(V % P <= L){
                sum += V % P;
            }else{
                sum += L;
            }
            System.out.println("Case " + count + ": " + sum);
        }
    }
}
