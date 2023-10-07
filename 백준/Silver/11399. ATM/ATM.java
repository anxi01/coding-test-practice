import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Node> data = new ArrayList<>();

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            data.add(new Node(i, sc.nextInt()));
        }
        Collections.sort(data, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.time, o2.time);
            }
        });

        int sum = 0;

        for(int i = 0; i < data.size(); i++){
            if(i == 0){
                sum += data.get(i).time;
            }else {
                for(int j = 0; j <= i; j++){
                    sum += data.get(j).time;
                }
            }
        }
        System.out.println(sum);
    }
    static class Node{
        int index;
        int time;

        Node(int i, int t){
            this.index = i;
            this.time = t;
        }
    }
}
