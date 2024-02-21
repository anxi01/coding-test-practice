class Solution {
  public String solution(String s) {

    // If n is non-positive then the pattern will be applied as many times as possible and the array can have any length. 
    // -1 : 공백의 최대로 나눔
    // ex) "a b " => "a", " ", "b", " " 
    String[] words = s.split(" ", -1);

    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) { 
        if (i % 2 == 0) {
          sb.append(word.toUpperCase().charAt(i));
        } else { 
          sb.append(word.toLowerCase().charAt(i));
        }
      }
      sb.append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }
}
