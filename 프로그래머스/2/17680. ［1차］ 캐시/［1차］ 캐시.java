import java.util.ArrayDeque;

/**
 * 풀이과정 :
 * 1. 도시 이름은 대소문자 구분을 하지 않기 때문에 대문자 혹은 소문자로 통일한다.
 * 2-1. 캐시에 도시가 있을 경우,
 *      - HIT를 더해준다.
 *      - 캐시에 해당 도시를 제거한다.
 *      - 다시 해당 도시를 넣어준다. (LRU 알고리즘)
 * 2-2. 캐시에 도시가 없을 경우,
 *      - MISS를 더해준다.
 *      - 캐시에 해당 도시를 넣어준다.
 *      - 만약, 캐시사이즈보다 커졌을 경우, 하나 제거해준다.
 */
class Solution {

    private static final int HIT = 1;
    private static final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        ArrayDeque<String> cache = new ArrayDeque<>();

        for (String city : cities) { // O(N) N = 100,000
            city = city.toLowerCase(); // O(N) N = 20
            if (cache.contains(city)) { // O(N * M)
                answer += HIT;
                cache.remove(city); // O(1)
                cache.addLast(city); // O(1)
            } else {
                answer += MISS;
                cache.addLast(city);
                if (cache.size() > cacheSize) {
                    cache.pollFirst();
                }
            }
        }

        return answer;
    }
}
