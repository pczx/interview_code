package leetcode;

import java.util.Arrays;

public class leetcode01_07 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] new_matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            new_matrix[i] = Arrays.copyOf(matrix[i], n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                new_matrix[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.copyOf(new_matrix[i], n);
        }
    }
}
