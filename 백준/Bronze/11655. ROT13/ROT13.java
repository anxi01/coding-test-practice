import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (('A' <= str.charAt(i) && str.charAt(i) <= 'Z')){
                if ((str.charAt(i) + 13) > 'Z') {
                    sb.append((char) ((12 - ('Z' - str.charAt(i)) + 'A')));
                }else sb.append((char) ((str.charAt(i) + 13)));
            } else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                if ((str.charAt(i) + 13) > 'z') {
                    sb.append((char) ((12 - ('z' - str.charAt(i)) + 'a')));
                }else sb.append((char) ((str.charAt(i) + 13)));
            } else sb.append(str.charAt(i));
        }

        System.out.println(sb);
    }
}
