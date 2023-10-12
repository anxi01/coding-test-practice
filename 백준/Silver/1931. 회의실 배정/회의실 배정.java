import java.util.*;

class Time{

    int start;
    int end;

    public Time(int s, int e){
        this.start = s;
        this.end = e;
    }
}
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Time> data = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            data.add(new Time(start, end));
        }
        // 끝나는 시간을 기준으로 오름차순 정렬
        // 만약 끝나는 시간이 같다면 시작 시간을 기준으로 오름차순 정렬
        data.sort(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.end == o2.end){
                    return Integer. compare(o1.start, o2.start);
                }else{
                    return Integer.compare(o1.end, o2.end);
                }
            }
        });

/*        int count = 0;
        int tmp = 0;

        for(int i = 0; i < n; i++){
            if(tmp <= data.get(i).start){
                count++;
                tmp = data.get(i).end;
            }
        }
        System.out.println(count);*/

        int end_time = data.get(0).end;
        int count = 1;
        for(int i = 1; i < n; i++){
            int start_time = data.get(i).start;
            if(start_time < end_time){
                continue;
            }
            end_time = data.get(i).end;
            count++;
        }
        System.out.println(count);
    }
}