/*
풀이과정
  1. 스트리밍 횟수를 각 장르별로 저장한다.
  2. 장르를 key로 가진 map을 생성하는데 그 map의 value는 고유번호를 가진 키와 그 재생 횟수를 값으로 가지는 map이다.
  3. 우선 장르 별로 재생 횟수가 높은 것부터 최대 2개씩 뽑을 수 있으므로, 재생 횟수 map(1번)의 keySet을 내림차순으로 저장한다.
  4. 장르를 순회하면서 최대 2개씩 answer 리스트에 넣는다.
*/

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
