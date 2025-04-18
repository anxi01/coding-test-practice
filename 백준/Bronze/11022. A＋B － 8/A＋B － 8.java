import java.io.*;
import java.util.*;

public class Main {

	private static String CASE_PREFIX = "Case #";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int sum = A + B;
			bw.write(CASE_PREFIX + i + ": " + A + " + " + B + " = " + sum + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}