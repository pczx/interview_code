package leetcode;

class Solution13 {
    public int movingCount(int m, int n, int k) {
        boolean[] visited = new boolean[m * n];
        int count = movingCountCore(m, n, k, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int rows, int cols, int k, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(rows, cols, k, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(rows, cols, k, row, col - 1, visited)
                    + movingCountCore(rows, cols, k, row, col + 1, visited)
                    + movingCountCore(rows, cols, k, row - 1, col, visited)
                    + movingCountCore(rows, cols, k, row + 1, col + 1, visited);
        }
        return count;
    }

    private boolean check(int rows, int cols, int k, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && getDigitSum(row) + getDigitSum(col) <= k && !visited[row * cols + col]) {
            return true;
        }
        return false;
    }

    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}