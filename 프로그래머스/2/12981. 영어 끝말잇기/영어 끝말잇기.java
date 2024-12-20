import java.util.HashSet;

/**
 * 아이디어 : [ 번호, 차례 ] 를 어떻게 구할지 떠올려야함.
 * - 번호 구하는 방법 (ex. n = 3) : 모듈러 연산 사용
 *   - words의 인덱스를 활용한다.
 *   - words의 인덱스 :                 0 1 2 | 3 4 5
 *   - words의 인덱스 % n (모듈러 연산) :  0 1 2 | 0 1 2
 *   - words의 인덱스 % n + 1 :         1 2 3 | 1 2 3
 *
 * - 차례 구하는 방법 (ex. n = 3) : 나누기 연산 사용
 *   - words의 인덱스를 활용한다.
 *   - words의 인덱스 :                 0 1 2 | 3 4 5
 *   - words의 인덱스 / n (나누기 연산) :  0 0 0 | 1 1 1
 *   - words의 인덱스 / n + 1 :         1 1 1 | 2 2 2
 */
class Solution {

    public int[] solution(int n, String[] words) {
        // 중복 단어 검증할 Set 자료구조 사용
        HashSet<String> usedWords = new HashSet<>();

        // 이전 단어의 마지막 문자를 설정
        // 처음 이전 단어는 존재하지 않으므로, 초기 글자의 앞 문자로 설정
        char prevWord = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            // 단어가 중복되거나, 이전 단어의 마지막 문자와 현재 단어의 처음 문자가 일치하지 않을 경우
            if (usedWords.contains(words[i]) || words[i].charAt(0) != prevWord) {
                // 위에서 구헀던 방식으로 번호와 차례를 반환
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            usedWords.add(words[i]);

            // 이전 단어 갱신
            prevWord = words[i].charAt(words[i].length() - 1);
        }
        return new int[]{0, 0};
    }
}
