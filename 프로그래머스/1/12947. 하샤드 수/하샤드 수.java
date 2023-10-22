class Solution {
    public boolean solution(int x) {

        String[] arr = String.valueOf(x).split("");

        int sum = 0;
        for(String data : arr){
            sum += Integer.parseInt(data);
        }
        return x % sum == 0;
    }
}