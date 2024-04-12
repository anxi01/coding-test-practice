class Solution {
    public static boolean solution(int[] arr, int target) {

        // O(N^2) 풀이 -> 입력 값이 10,000이기 때문에 시간 초과
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
