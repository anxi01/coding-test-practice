class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        int row = board.length;
        int col = board[0].length;

        // 1부터 시작하기
        // 0부터 시작하면 왼쪽 대각선, 위쪽, 왼쪽 값을 비교하는데 index 에러 발생
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] > 0) {
                    // board[i][j]가 1인 경우, 그 칸을 오른쪽 아래 꼭짓점으로 하는 가장 큰 정사각형의 한 변의 길이 구하기
                    // 따라서 왼쪽, 왼쪽 대각선, 위쪽이 전부 1로 채운다고 생각하기
                    // 위쪽, 왼쪽 대각선, 왼쪽 값 비교 후 최솟값 + 현재 board 값
                    board[i][j] += Math.min(board[i - 1][j], Math.min(board[i - 1][j - 1], board[i][j - 1]));
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer * answer;
    }
}
