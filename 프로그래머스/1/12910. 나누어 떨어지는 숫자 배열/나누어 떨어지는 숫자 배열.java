import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        int i = 0;
        for(int data : arr){
            if(data % divisor == 0){
                i++;
            }
        }

        int[] answer = new int[i];
        if(i == 0){
            answer = new int[]{-1};
        }

        i = 0;
        for(int data : arr){
            if(data % divisor == 0){
                answer[i] = data;
                i++;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}