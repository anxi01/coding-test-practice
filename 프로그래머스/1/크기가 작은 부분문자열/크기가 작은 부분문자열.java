import java.util.ArrayList;
import java.util.List;

class Solution {
  public int solution(String t, String p) {

    // p의 길이는 최대 18까지이므로 Integer의 길이를 벗어나기 때문에 Long으로 바꿔준다. 
    List<Long> data = new ArrayList<>();
    for (int i = 0; i <= t.length() - p.length(); i++) {
      data.add(Long.parseLong(t.substring(i, i + p.length())));
    }
    return (int) data.stream().filter(s -> s <= Long.parseLong(p)).count();
  }
}
