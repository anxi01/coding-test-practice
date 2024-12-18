import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 풀이
 * - 간단한 문제
 * - 조건 1. 중복 제거 후 요소의 개수
 * - 조건 2. N / 2 개
 * 
 * - 조건 1 > 조건 2, return 조건 2
 * - 조건 1 < 조건 2, return 조건 1
 */
class Solution {

    // 1번 풀이
    public int solution1(int[] nums) {
        int max = nums.length / 2;
        // Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().toList());
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Math.min(max, set.size());
    }

    // 2번 풀이
    public int solution2(int[] nums) {
        return (int) Math.min(Arrays.stream(nums).distinct().count(), nums.length / 2);
    }
}
