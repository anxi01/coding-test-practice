import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int gcf = 1;
        ArrayList<Integer> gcfList = new ArrayList<>();
        
        while (gcf <= Math.min(n1, n2)) {
            if (n1 % gcf == 0 && n2 % gcf == 0)
                gcfList.add(gcf);
            gcf++;
        }
        gcf = Collections.max(gcfList);

        int lcm = gcf * (n1 / gcf) * (n2 / gcf);

        System.out.println(gcf);
        System.out.println(lcm);
    }
}
