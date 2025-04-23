import java.io.*;

// 글자가 포함되어 있을 경우, replace()를 사용해서 교체하기
// "z=", "dz=" 의 경우, "z="를 먼저 .으로 변경하게 되면
// "d."으로 돼서 더이상 변경할 수 없게 된다.
// 따라서, 중복되는 글자가 있음 더 많은 범위를 커버할 수 있는 단어를 먼저 배열에 넣기!
public class Main {

    private static String[] alphabets = {
        "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (String alpha : alphabets) {
            input = input.replace(alpha, ".");
        }

        System.out.print(input.length());
    }
}