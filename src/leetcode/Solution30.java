package leetcode;

public class Solution30 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int total = rows * cols;
        int[] ans = new int[total];
        //方向
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0;
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            ans[i] = matrix[row][col];
            visited[row][col] = true;
            int nextRow = row + directions[directionIndex][0], nextCol = col + directions[directionIndex][1];
            //边界条件判断
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return ans;
    }
}
