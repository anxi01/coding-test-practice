import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        String n = br.readLine();
        for(int i = 0; i < n.length(); i++){
            list.add(Integer.parseInt(String.valueOf(n.charAt(i))));
        }
        Collections.sort(list);
        Collections.reverse(list);

        for(int N : list){
            System.out.print(N);
        }
    }
}