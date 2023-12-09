class Solution {
    public boolean solution(String s) {
        String[] strings = s.split("");
        boolean answer = false;

        if (strings.length == 4 || strings.length == 6) {
            answer = true;
        }

        if (answer) {
            for (String ss : strings) {
                try{
                    Integer.parseInt(ss);
                }catch (NumberFormatException e){
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}