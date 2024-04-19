import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
  public static String[] solution(String[] record) {

    final String ENTER = "Enter";
    final String LEAVE = "Leave";
    final String CHANGE = "Change";

    final String ENTER_KOR = "님이 들어왔습니다.";
    final String LEAVE_KOR = "님이 나갔습니다.";

    HashMap<String, String> map = new HashMap<>();

    for (String r : record) {
      String[] tmp = r.split(" ");
      if (tmp[0].equals(ENTER) || tmp[0].equals(CHANGE)) {
        map.put(tmp[1], tmp[2]);
      }
    }

    List<String> list = new ArrayList<>();
    for (String r : record) {
      String[] tmp = r.split(" ");

      switch (tmp[0]) {
        case ENTER:
          list.add(map.get(tmp[1]) + ENTER_KOR);
          break;
        case LEAVE:
          list.add(map.get(tmp[1]) + LEAVE_KOR);
      }
    }

    // List -> String[]으로 변경하는 방법
    // toArray(new String[0]); || toArray(new String[list.size()]);
    return list.toArray(new String[0]);
  }
}
