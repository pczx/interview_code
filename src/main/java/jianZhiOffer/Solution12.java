package jianZhiOffer;

public class Solution12 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[] visited = new boolean[rows * cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (existCore(board, rows, cols, row, col, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existCore(char[][] board, int rows, int cols, int row, int col, int i, String word, boolean[] visited) {
        if (i == word.length() - 1) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == word.charAt(i) && !visited[row * cols + col]) {
            i++;
            visited[row * cols + col] = true;
            hasPath = existCore(board, rows, cols, row, col - 1, i, word, visited)
                    || existCore(board, rows, cols, row, col + 1, i, word, visited)
                    || existCore(board, rows, cols, row - 1, col, i, word, visited)
                    || existCore(board, rows, cols, row + 1, col, i, word, visited);
            if (!hasPath) {
                i--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}
