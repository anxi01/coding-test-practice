import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = 0;
        int sum = 0;
        int count = 0;
        while(true){
            if(n - sum <= k){
                k = 0;
            }
            if(sum == n){
                break;
            }
            k++;
            sum += k;
            count++;
        }
        System.out.println(count);
    }
}