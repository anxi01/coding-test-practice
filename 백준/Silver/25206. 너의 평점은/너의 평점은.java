import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static final Map<String, Double> subjectAvg = Map.of(
            "A+", 4.5, "A0", 4.0,
            "B+", 3.5, "B0", 3.0,
            "C+", 2.5, "C0", 2.0,
            "D+", 1.5, "D0", 1.0,
            "F", 0.0
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalGrade = 0;
        double totalCredit = 0.0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (!"P".equals(grade)) {
                totalGrade += credit * subjectAvg.get(grade);
                totalCredit += credit;
            }
        }

        // 소수점 아래 6번째까지 반올림
        System.out.printf("%.6f", totalGrade / totalCredit);
    }
}
