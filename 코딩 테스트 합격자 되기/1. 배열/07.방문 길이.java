import java.util.HashMap;
import java.util.HashSet;

// 중복 제거할 때 해시셋을 생각해보는게 좋다.

class Solution {
  public static int solution(String dirs) {
    HashMap<Character, int[]> map = new HashMap<>();

    map.put('U', new int[]{0, 1});
    map.put('D', new int[]{0, -1});
    map.put('L', new int[]{-1, 0});
    map.put('R', new int[]{1, 0});

    HashSet<String> set = new HashSet<>();
    int x = 5, y = 5;
    for (int i = 0; i < dirs.length(); i++) {
      int[] offset = map.get(dirs.charAt(i));

      int nx = x + offset[0];
      int ny = y + offset[1];

      if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
        continue;
      }

      set.add(x + " " + y + " " + nx + " " + ny);
      set.add(nx + " " + ny + " " + x + " " + y);

      x = nx;
      y = ny;
    }
    return set.size() / 2;
  }
}
/*
// 기존코드
// 중복을 허용하지 않기 때문에 해시셋을 이용하여 중복 처리를 하려 하였다.
// 좌표를 객체로 받아서 좌표를 Set에 넣어두고 좌표가 같지 않을 때만 길이를 1씩 더하면 되는 간단한 문제인줄 알았으나 그렇지 않았다.
class Solution {

  static class Coordinate {
    int x, y;

    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int solution(String dirs) {
    HashSet<Coordinate> set = new HashSet<>();

    int x = 0;
    int y = 0;
    for (int i = 0; i < dirs.length(); i++) {
      char word = dirs.charAt(i);

      if (word == 'U') {
        y++;
      } else if (word == 'D') {
        y--;
      } else if (word == 'R') {
        x++;
      } else if (word == 'L') {
        x--;
      }

      // 좌표평면 벗어나는지 체크
      if (x > 5 || x < -5 || y > 5 || y < -5) {
        continue;
      }
      
      set.add(new Coordinate(x, y));
    }
    return -1;
  }
}
*/
