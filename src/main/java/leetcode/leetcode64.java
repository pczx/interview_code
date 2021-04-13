package leetcode;

import java.util.Arrays;

public class leetcode64 {
    private int M;
    private int N;
    private int[][] memo;

    public int minPathSum(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(grid, 0, 0);
    }

    public int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= M || c < 0 || c >= N) {
            return Integer.MAX_VALUE;
        }
        if (memo[r][c] > -1) {
            return memo[r][c];
        }
        if (r == M - 1 && c == N - 1) {
            return grid[M - 1][N - 1];
        }

        int right = dfs(grid, r, c + 1);
        int down = dfs(grid, r + 1, c);
        int ans = Math.min(right, down) + grid[r][c];
        memo[r][c] = ans;
        return ans;
    }
}
