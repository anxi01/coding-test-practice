import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			int grade = Integer.parseInt(st.nextToken());
			arr[i] = grade;
			max = Math.max(max, grade);
		}

		double avg = 0;
		for (int i = 0; i < N; i++) {
			avg += (double) arr[i] / max * 100; // 형변환하기!
		}

		System.out.print(avg / N);
	}
}
