class Solution {
    public int solution(int[] numbers) {
        int[] allNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int sum = 0;
        for (int a : allNumbers) {
            boolean isTrue = false;
            for (int b : numbers) {
                if (a == b) {
                    isTrue = true;
                    break;
                }
            }
            if (!isTrue) {
                sum += a;
            }
        }
        return sum;
    }
}