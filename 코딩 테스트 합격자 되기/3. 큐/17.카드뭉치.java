import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

class Solution {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> cards1Queue = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> cards2Queue = new ArrayDeque<>(Arrays.asList(cards2));

        for (int i = 0; i < goal.length; i++) {
            if (Objects.equals(cards1Queue.peek(), goal[i])) {
                cards1Queue.poll();
            } else if (Objects.equals(cards2Queue.peek(), goal[i])) {
                cards2Queue.poll();
            } else {
                return "No";
            }
        }

        if (cards1Queue.isEmpty() && cards2Queue.isEmpty()) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
