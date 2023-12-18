import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        List<String> suffix = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            suffix.add(str.substring(i));
        }

        Collections.sort(suffix);

        for (String s : suffix) {
            System.out.println(s);
        }
    }
}
