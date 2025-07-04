import java.io.*;
import java.util.*;

public class Main {

    private static class Meeting {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 회의가 끝나는 시간 오름차순으로 정렬
        // 가장 빨리 끝나는 회의를 먼저 쳐내야 함
        meetings.sort((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int endTime = meetings.get(0).end;
        int maxCount = 1;
        for (int i = 1; i < meetings.size(); i++) {
            if (meetings.get(i).start >= endTime) {
                endTime = meetings.get(i).end;
                maxCount++;
            }
        }

        System.out.println(maxCount);
    }
}
