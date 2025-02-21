import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MINUTES_IN_HOUR = 60;
    private static final int HOURS_IN_DAY = 24;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());

        int totalMinutes = B + C;
        int finalHours = (A + totalMinutes / MINUTES_IN_HOUR) % HOURS_IN_DAY;
        int finalMinutes = totalMinutes % MINUTES_IN_HOUR;

        System.out.println(finalHours + " " + finalMinutes);
    }
}
