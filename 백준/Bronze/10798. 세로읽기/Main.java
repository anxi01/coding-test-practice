import java.io.*;

// 배열을 모두 '\0'(널 문자)로 초기화
// 열(column) 먼저, 행(row) 나중
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                board[i][j] = line.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < 15; col++) {
            for (int row = 0; row < 5; row++) {
                if (board[row][col] != '\0') {
                    sb.append(board[row][col]);
                }
            }
        }
        System.out.println(sb);
    }
}
