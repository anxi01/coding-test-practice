class Solution {
    public int solution(int n) {
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            boolean flag = true;
            
            // i의 제곱근까지만 검사
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) { 
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }
}
