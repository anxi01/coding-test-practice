class Solution {
    boolean solution(String s) {
        int countP = 0;
        int countY = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'P' ||s.charAt(i) == 'p')
                countP++;
            if(s.charAt(i) == 'Y' ||s.charAt(i) == 'y')
                countY++;
        }
        return countP == countY;
    }
}