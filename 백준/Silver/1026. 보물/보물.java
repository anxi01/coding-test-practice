import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = sc.nextInt();
        }
        // 각 배열을 오름차순으로 정렬
        Arrays.sort(a);
        Arrays.sort(b);

        int sum = 0;
        // a는 최소일 때, b는 최대일 때를 곱해서 더해야 최소가 될 수 있다.
        for(int i = 0; i < n; i++){
            sum += a[i] * b[n-i-1];
        }
        System.out.println(sum);
    }
}