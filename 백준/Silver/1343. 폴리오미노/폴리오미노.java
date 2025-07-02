import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < board.length(); i++) {
            char ch = board.charAt(i);

            // X일 경우, X를 카운트
            if (ch == 'X') {
                count++;
            } else { // .일 경우
                // X가 있을 경우
                if (count > 0) {
                    // X가 2의 배수가 아니면 폴리오미노로 겹쳐서 만들 수 없기 때문에 -1 반환
                    if (count % 2 != 0) {
                        System.out.println("-1");
                        return;
                    }
                    // X의 개수를 4로 나눠 AAAA 반복
                    result.append("AAAA".repeat(count / 4));

                    // 4로 나눈 나머지가 2(BB)라면 BB도 추가
                    if ((count % 4) == 2) {
                        result.append("BB");
                    }

                    // 다음 단어로 넘어가기 때문에 0으로 초기화
                    count = 0;
                }

                result.append(".");
            }
        }

        // X만 있을 경우
        if (count > 0) {
            if (count % 2 != 0) {
                System.out.println("-1");
                return;
            }
            result.append("AAAA".repeat(count / 4));
            if ((count % 4) == 2) {
                result.append("BB");
            }
        }

        System.out.println(result);
    }
}
