import java.util.Scanner;

public class Main {

    /**
     * 재귀 호출 : 2X2 형태 크기 이상일 경우,
     *           재귀 호출을 통해 절반씩 쪼개서
     *           수행한다.
     *
     *           (도움)
     *           https://ilmiodiario.tistory.com/140
     */
    public static int N, R, C, result = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();

        solve((int) Math.pow(2, N), 0, 0);
    }
    public static void solve(int size, int r, int c){

        if(size == 1){
            System.out.println(result);
            return;
        }
        int newSize = size / 2;

        // 1사분면
        if (R < r + newSize && C < c + newSize) {
            solve(newSize, r, c);
        }
        // 2사분면
        if(R < r + newSize && c + newSize <= C){
            result += (size * size) / 4;
            solve(newSize, r, c + newSize);
        }
        // 3사분면
        if (r + newSize <= R && C < c + newSize) {
            result += ((size * size) / 4) * 2;
            solve(newSize, r + newSize, c);
        }
        // 4사분면
        if (r + newSize <= R && c + newSize <= C) {
            result += ((size * size) / 4) * 3;
            solve(newSize, r + newSize, c + newSize);
        }
    }
}