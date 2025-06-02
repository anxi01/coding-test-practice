import java.io.*;
import java.util.*;

/**
 * Set으로 중복 제거 후에 List로 감싸서 정렬하기.
 * Collections 정렬도 매개변수에서 List를 사용하기 때문에 감싸기.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> words = new ArrayList<>(set);
        words.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return Integer.compare(o1.length(), o2.length());
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word + "\n");
        }

        System.out.println(sb);
    }
}
