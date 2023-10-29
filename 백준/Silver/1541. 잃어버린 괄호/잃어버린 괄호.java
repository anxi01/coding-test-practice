import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split("-");
        int sum = 0;

        if(data[0].contains("+")){
            String[] data2 = data[0].split("\\+");
            for(String d : data2){
                sum += Integer.parseInt(d);
            }
        }else{
            sum += Integer.parseInt(data[0]);
        }
        
        for(int i = 1; i < data.length; i++){
            if(data[i].contains("+")){
                String[] data2 = data[i].split("\\+");
                for(String d : data2){
                    sum -= Integer.parseInt(d);
                }
            }else{
                sum -= Integer.parseInt(data[i]);
            }
        }
        System.out.println(sum);
    }
}
