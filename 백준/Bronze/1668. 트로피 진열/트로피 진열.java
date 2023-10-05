import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(count(list));
        Collections.reverse(list);
        System.out.println(count(list));

    }
    public static int count(List<Integer> list){
        int now = list.get(0);
        int result = 1;

        for(int i = 1; i < list.size(); i++){
            if(now < list.get(i)){
                result += 1;
                now = list.get(i);
            }
        }
        /* 이런 식으로 변경하는게 좋음
        for(int k : list){
            if(now < k){
                result += 1;
                now = k;
            }
        }
        */
        return result;
    }
}