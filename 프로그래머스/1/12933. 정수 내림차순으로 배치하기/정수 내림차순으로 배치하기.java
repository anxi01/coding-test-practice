import java.util.Arrays;

class Solution {
    public long solution(long n) {
        // 각 숫자를 배열에 입력 후
        String[] a = String.valueOf(n).split("");
        // 정렬
        Arrays.sort(a);

        // StringBuilder 사용
        StringBuilder result = new StringBuilder();
        for(int i = a.length - 1; i >= 0; i--){
            result.append(a[i]);
        }
        return Long.parseLong(String.valueOf(result));
    }
}