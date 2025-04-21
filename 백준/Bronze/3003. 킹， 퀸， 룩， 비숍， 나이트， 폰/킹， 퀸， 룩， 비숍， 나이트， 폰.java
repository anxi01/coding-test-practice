import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int[] pieces = { 1, 1, 2, 2, 2, 8 };
        for (int piece : pieces) {
            int inputPiece = Integer.parseInt(st.nextToken());
            sb.append(piece - inputPiece).append(" ");
        }

        System.out.print(sb);
    }
}
