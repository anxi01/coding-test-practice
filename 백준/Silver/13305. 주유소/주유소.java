import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] roadLength = new int[n - 1];
        int[] price = new int[n];

        for (int i = 0; i < n - 1; i++) {
            roadLength[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            price[i] = sc.nextInt();
        }
        
        // 배열의 0번째 값을 기준으로 다음 인덱스의 값을 비교
        // 그중 최소를 배열에 다시 저장
        int minPrice = price[0];
        for(int i = 1; i < n; i++){
            minPrice = Math.min(minPrice, price[i]);
            price[i] = minPrice;
        }

        int result = 0;
        for(int i = 0; i < n-1; i++){
            result += roadLength[i] * price[i];
        }
        
        System.out.println(result);
    }
}