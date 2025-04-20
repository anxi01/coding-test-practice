import java.io.*;
import java.util.*;

/*
	BufferedReader.readLine()은 더 이상 읽을 줄이 없으면 null을 반환 !
	while ((line = br.readLine()) != null) 형태로 사용하면, 입력이 끝날 때 자동으로 빠져나올 수 있다!
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
        	System.out.println(str);
        }
    }
}
