import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        /*
        Todo. Queue가 비었을 경우는 탐색하지 않는 조건을 달아줘야 함.
         */

        // cards와 goal을 queue로 변환
        Queue<String> cardsQueue1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> cardsQueue2 = new ArrayDeque<>(Arrays.asList(cards2));
        Queue<String> goalQueue = new ArrayDeque<>(Arrays.asList(goal));

        // goalQueue에 문자열이 남아 있으면 계속 반복
        while (!goalQueue.isEmpty()) {
            // cardQueue1의 front와 일치하는 경우
            if (!cardsQueue1.isEmpty() && cardsQueue1.peek().equals(goalQueue.peek())) {
                cardsQueue1.poll();
                goalQueue.poll();
            }
            // cardQueue2의 front와 일치하는 경우
            else if (!cardsQueue2.isEmpty() && cardsQueue2.peek().equals(goalQueue.peek())) {
                cardsQueue2.poll();
                goalQueue.poll();
            }
            else {
                break; // 일치하는 원소가 없을 경우 종료
            }
        }

        return goalQueue.isEmpty() ? "Yes" : "No";
    }
}
