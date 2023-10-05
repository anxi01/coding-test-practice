import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2차원 배열 이용
        char[][] data = new char[50][50];
        int[] row = new int[50];
        int[] col = new int[50];

        for(int i=0; i<n; i++){
            data[i] = br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                // X인 곳을 행과 열에 각각 1로 초기화
                if(data[i][j]== 'X'){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        // 각 행과 열에서 X가 없는 경우 경비원이 필요한 경우이므로
        // count를 증가시킨다.
        int rowCount = 0;
        for(int i = 0; i < n; i++){
            if(row[i] == 0) rowCount++;
        }
        int colCount = 0;
        for(int i = 0; i < m; i++){
            if(col[i] == 0) colCount++;
        }
        System.out.println(Math.max(rowCount, colCount));
    }
}