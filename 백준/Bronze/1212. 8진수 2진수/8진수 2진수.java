import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String octal = br.readLine();
        String[] binaries = {"000", "001", "010", "011", "100", "101", "110", "111"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < octal.length(); i++) {
            int idx = octal.charAt(i) - '0';

            if (octal.equals("0")) {
                sb.append(0);
                break;
            }

            if (i == 0 && idx == 1) {
                sb.append(1);
            } else if (i == 0 && idx < 4) {
                sb.append(binaries[idx].substring(1));
            } else {
                sb.append(binaries[idx]);
            }
        }
        System.out.println(sb);
    }
}
