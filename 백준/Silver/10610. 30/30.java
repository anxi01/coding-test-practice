import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split("");

        // 내림차순으로 출력
        Arrays.sort(data, Collections.reverseOrder());
        StringBuffer sb = new StringBuffer();

        int sum = 0;
        int isZero = 0;
        for (String each : data) {
            sum += Integer.parseInt(each);
            sb.append(each);
            if(Objects.equals(each, "0")){
                isZero++;
            }
        }
        if(isZero > 0 && sum % 3 == 0){
            System.out.println(sb);
        }else System.out.println(-1);
    }
        /*
        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2) - Integer.parseInt(o1);
            }
        });
        */
}
