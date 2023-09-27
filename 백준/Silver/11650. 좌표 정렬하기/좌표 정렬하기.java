import java.util.*;

class Node{
    public int x;
    public int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.add(new Node(a, b));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.x == o2.x){
                    return Integer.compare(o1.y, o2.y);
                }else 
                return Integer.compare(o1.x, o2.x);
            }
        });

        for(Node nd : list){
            System.out.println(nd.x + " " + nd.y);
        }
    }
}