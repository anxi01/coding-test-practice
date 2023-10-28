import java.util.*;

class Node{
    int document;
    int interview;
    Node(int d, int i){
        this.document = d;
        this.interview = i;
    }
}
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            ArrayList<Node> data = new ArrayList<>();
            for(int j = 0; j < n; j++){
                data.add(new Node(sc.nextInt(), sc.nextInt()));
            }
            data.sort((o1, o2) -> o1.document - o2.document);

            int count = 1;
            int compare = data.get(0).interview;
            for(int k = 1; k < n; k++){
                if(data.get(k).interview < compare){
                    count++;
                    compare = Math.min(compare, data.get(k).interview);
                }
            }
            System.out.println(count);
        }
    }
}
