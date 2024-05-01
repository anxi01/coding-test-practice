import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
  public static int[] solution(String[] genres, int[] plays) {

    HashMap<String, Integer> totalMap = new HashMap<>();

    for (int i = 0; i < genres.length; i++) {
      totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
    }

    HashMap<String, HashMap<Integer, Integer>> genreCountMap = new HashMap<>();

    for (int i = 0; i < plays.length; i++) {
      if (!genreCountMap.containsKey(genres[i])) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(i, plays[i]);
        genreCountMap.put(genres[i], countMap);
      } else {
        genreCountMap.get(genres[i]).put(i, plays[i]);
      }
    }

    List<String> keySet = new ArrayList<>(totalMap.keySet());
    // 값을 기준으로 내림차순 정렬
    keySet.sort(((o1, o2) -> totalMap.get(o2) - totalMap.get(o1)));

    List<Integer> answer = new ArrayList<>();
    for (String key : keySet) {
      HashMap<Integer, Integer> countMap = genreCountMap.get(key);
      List<Integer> genreKeys = new ArrayList<>(countMap.keySet());

      // 값을 기준으로 내림차순 정렬
      genreKeys.sort(((o1, o2) -> countMap.get(o2) - countMap.get(o1)));

      // 각 장르 별로 최대 2곡만 가능하다.
      answer.add(genreKeys.get(0));
      if (genreKeys.size() > 1) {
        answer.add(genreKeys.get(1));
      }
    }

    return answer.stream().mapToInt(s -> s).toArray();
  }
}