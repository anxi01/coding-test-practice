class Solution {
  public static int[] solution(int[] numbers) {

    // 중복 제거이므로 Set을 사용한다.
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        set.add(numbers[i] + numbers[j]);
      }
    }

    // 오름차순 정렬 및 반환
    return set.stream().sorted().mapToInt(Integer::intValue).toArray();
  }
}
