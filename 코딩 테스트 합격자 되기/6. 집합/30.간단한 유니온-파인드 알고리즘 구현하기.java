import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 집합 문제 풀이
 * 1. 배열 초기화
 *   - 배열 초기화 시, 노드의 수 만큼 설정
 *   - 배열 초기화 시, 자기 자신을 부모로 가지도록 초기화
 *   - 인덱스 : 원소의 값
 *   - 값 : 부모 노드
 * 2. union(x, y) : 부모 노드를 구해서 하나의 부모 노드에 합침
 * 3. find(x) : 부모노드일 경우 반환, 그렇지 않으면 재귀를 통해 찾아서 반환
 */

class Solution {

    // 0이면 union(x, y)
    // 1이면 find(x, y)
    private static int[] parent;

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1; // y가 속한 집합을 x가 속한 집합에 합침
    }

    private static int find(int x) {
        // 부모 노드일 경우
        if (parent[x] == x) {
            return x;
        }
        // 그렇지 않으면 x의 부모를 찾아서 parent[x]에 저장
        parent[x] = find(parent[x]);
        return parent[x]; // 찾은 루트 노드 반환
    }

    private static Boolean[] solution(int k, int[][] operations) {
        // 노드의 수 만큼 배열 초기화
        parent = new int[k];

        // 처음에는 각 노드가 자기 자신을 부모로 가지도록 초기화
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] operation : operations) {
            // union
            if (operation[0] == 0) {
                union(operation[1], operation[2]);
            } else {
                // find
                result.add(find(operation[1]) == find(operation[2]));
            }
        }
        return result.toArray(new Boolean[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[][]{{0, 0, 1,}, {0, 1, 2,}, {1, 1, 2,}})));
    }
}
