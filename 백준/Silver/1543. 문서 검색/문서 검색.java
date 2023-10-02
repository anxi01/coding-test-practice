import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String word = br.readLine();
        int index = 0;
        int count = 0;

        while(doc.length() >= word.length() + index){
            if(doc.substring(index, index + word.length()).equals(word)){
                count++;
                index += word.length();
            }else{
                index++;
            }
        }
        System.out.println(count);
    }
}