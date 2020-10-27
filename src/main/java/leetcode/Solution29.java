package leetcode;

public class Solution29 {
    int index = 0;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int[] ans = new int[rows * cols];

        while (cols > 2 * start && rows > 2 * start) {
            printMatrixInCircle(matrix, rows, cols, start, ans);
            start++;
        }
        return ans;
    }

    private void printMatrixInCircle(int[][] matrix, int rows, int cols, int start, int[] result) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        for (int i = start; i <= endX; i++) {
            result[index++] = matrix[start][i];
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                result[index++] = matrix[i][endX];
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                result[index++] = matrix[endY][i];
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                result[index++] = matrix[i][start];
            }
        }
    }
}
