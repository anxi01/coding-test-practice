import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        /**
         * 재귀함수 사용시 시간 초과 fib(n) = fib(n-1) + fib(n-2) X
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int a = 0;
        int b = 1;

        while(n > 1){
            int temp = a;
            a = b;
            b = temp + b;
            n--;
        }
        System.out.println(b);
    }
}