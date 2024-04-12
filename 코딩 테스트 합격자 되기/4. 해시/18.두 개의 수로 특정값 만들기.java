import java.util.HashSet;

class Solution {
    public static boolean solution(int[] arr, int target) {

        HashSet<Integer> hashSet = new HashSet<>();

        // target - arr의 원소이 해시셋에 존재하면 true
        // 그렇지 않으면 현재 arr의 원소를 넣기
        
        for (int i : arr) {
            // target에서 현재 원소를 뺀 값이 해시셋에 있는지 확인
            if (hashSet.contains(target - i)) {
                return true;
            }

            // 해시셋에 현재 값 저장
            hashSet.add(i);
        }

        return false;
    }
}
