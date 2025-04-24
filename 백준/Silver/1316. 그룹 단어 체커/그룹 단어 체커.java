import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            boolean[] check = new boolean[26];
            boolean isGroup = true;

            for (int j = 0; j < word.length(); j++) {
                char current = word.charAt(j);

                // 앞선 문자와 같을 경우, continue로 중복 허용
                if (j > 0 && current == word.charAt(j - 1)) {
                    continue;
                }

                // 이전에 나왔던 문자인데 연속이 아니면 isGroup = false
                if (check[current - 'a']) {
                    isGroup = false;
                    break;
                }

                // 처음 나온 알파벳일 경우, 등록하기
                check[current - 'a'] = true;
            }

            if (isGroup) {
                answer++;
            }
        }

        System.out.print(answer);
    }
}
