import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        list.sort(Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}