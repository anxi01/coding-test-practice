import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Integer[] ropes = new Integer[n];

        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }

        // 내림차순 정렬
        Arrays.sort(ropes, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int max = ropes[0];
        for (int i = 1; i < n; i++) {
            if (ropes[i] * (i + 1) >= max) {
                max = ropes[i] * (i + 1);
            }
        }
        System.out.println(max);
    }
}