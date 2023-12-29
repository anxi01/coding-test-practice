class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        while (left <= right) {
            if (count(left) % 2 == 0) {
                answer += left;
            } else {
                answer -= left;
            }
            left++;
        }
        return answer;
    }

    public int count(int left) {
        int i = 1;
        int count = 0;
        while (i <= left) {
            if (left % i == 0) {
                count++;
            }
            i++;
        }
        return count;
    }
}