import java.io.*;
import java.util.*;

public class Main {
	private static int ATTENDANCE_NUMBER = 30;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[ATTENDANCE_NUMBER + 1];

		for (int i = 1; i <= ATTENDANCE_NUMBER; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < 28; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[n] = 0;
		}
		
		for (int element : arr) {
			if (element != 0) {
				System.out.println(element);
			}
		}
	}
}