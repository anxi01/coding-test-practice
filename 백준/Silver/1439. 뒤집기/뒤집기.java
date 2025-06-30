import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        StringBuilder all0 = new StringBuilder();
        StringBuilder all1 = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            all0.append("0");
            all1.append("1");
        }

        if (S.equals(all0.toString()) || S.equals(all1.toString())) {
            System.out.print(0);
            return;
        }

        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                if (i >= 1 && S.charAt(i - 1) == '0') {
                    count1++;
                }
                if (i == S.length() - 1) {
                    count0++;
                }
            }

            if (S.charAt(i) == '0') {
                if (i >= 1 && S.charAt(i - 1) == '1') {
                    count0++;
                }
                if (i == S.length() - 1) {
                    count1++;
                }
            }
        }

        if (count0 == 0 || count1 == 0) {
            System.out.print(Math.max(count0, count1));
            return;
        }

        System.out.print(Math.min(count0, count1));
    }
}
