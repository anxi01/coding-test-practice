import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max_value = 0;
        // HashMap 사용
        Map<String, Integer> books = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String book = br.readLine();

            if(books.containsKey(book)){
                books.put(book, books.get(book) + 1);
            }
            else {
                books.put(book, 1);
            }
            max_value = Math.max(max_value, books.get(book));
        }

        for(String k : books.keySet()){
            if(books.get(k) == max_value)
                result.add(k);
        }
        Collections.sort(result);
        System.out.println(result.get(0));
    }
}