class Solution {
    public long solution(long num) {

        long count = 0;
        do {
            if (num == 1) break;
            if(count > 500){
                count = -1;
                break;
            }

            if(num % 2 == 0){
                num /= 2;
            }else {
                num = num * 3 + 1;
            }
            count++;
        }while (num != 1);

        return count;
    }
}