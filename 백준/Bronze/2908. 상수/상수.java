import java.io.*;
import java.util.*;

// char끼리 더해서 문자열을 만들고 싶을 때는 ""(빈 문자열)을 붙이기!
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		char[] originalA = st.nextToken().toCharArray();
		char[] originalB = st.nextToken().toCharArray();

		// character끼리 더해질 때는 정수값(ASCII Value)끼리 더해지기 때문에 String 문자열 혹은 StringBuilder를 사용할 수 있다.
		String reverseA = "" + originalA[2] + originalA[1] + originalA[0];
		String reverseB = "" + originalB[2] + originalB[1] + originalB[0];

		int A = Integer.parseInt(reverseA);
		int B = Integer.parseInt(reverseB);

		System.out.print(Math.max(A, B));
	}
}