import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] charArr = br.readLine().toCharArray();
            sb.append(charArr[0]).append(charArr[charArr.length - 1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
