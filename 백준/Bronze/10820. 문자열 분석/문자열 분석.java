import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        int[] arr;

        while ((str = br.readLine()) != null) {
            arr = new int[4];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if ('a' <= c && c <= 'z') {
                    arr[0]++;
                }else if ('A' <= c && c <= 'Z') {
                    arr[1]++;
                } else if ('0' <= c && c <= '9') {
                    arr[2]++;
                } else if (c == ' ') {
                    arr[3]++;
                }
            }
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]);
        }
    }
}
