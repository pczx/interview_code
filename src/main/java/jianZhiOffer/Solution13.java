package jianZhiOffer;

class Solution13 {
    public int movingCount(int m, int n, int k) {
        if (k < 0 || m <= 0 || n <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[m * n];
        int count = movingCountCore(0, 0, m, n, k, visited);
        return count;
    }

    private int movingCountCore(int row, int col, int rows, int cols, int k, boolean[] visited) {
        int count = 0;
        if (check(row, col, rows, cols, k, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(row, col - 1, rows, cols, k, visited)
                    + movingCountCore(row, col + 1, rows, cols, k, visited)
                    + movingCountCore(row - 1, col, rows, cols, k, visited)
                    + movingCountCore(row + 1, col, rows, cols, k, visited);
        }
        return count;
    }

    private boolean check(int row, int col, int rows, int cols, int k, boolean[] visited) {
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