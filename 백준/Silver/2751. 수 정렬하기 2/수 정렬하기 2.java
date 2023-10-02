import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            list.add(k);
        }
        Collections.sort(list);

        // StringBuilder 사용 -> 시간 초과 방지
        StringBuilder sb = new StringBuilder();

        for(int data : list){
            sb.append(data).append("\n");
        }
        System.out.println(sb);
    }
}