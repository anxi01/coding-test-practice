import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Coordinate {
        int x, y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<Coordinate> coordinateList = new ArrayList<>();
        Set<Coordinate> coordinateSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coordinateList.add(new Coordinate(x, y));
            coordinateSet.add(new Coordinate(x, y));
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            Coordinate c1 = coordinateList.get(i);

            Coordinate c2 = new Coordinate(c1.x + A, c1.y);
            Coordinate c3 = new Coordinate(c1.x, c1.y + B);
            Coordinate c4 = new Coordinate(c1.x + A, c1.y + B);

            if (coordinateSet.contains(c2) && coordinateSet.contains(c3) && coordinateSet.contains(c4)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
