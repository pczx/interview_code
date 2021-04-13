package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode54 {

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        int start = 0;
        while (2 * start < matrix.length && 2 * start < matrix[0].length) {
            print(matrix, start);
            start++;
        }
        return ans;
    }

    private void print(int[][] matrix, int start) {
        int endX = matrix[0].length - 1 - start;
        int endY = matrix.length - 1 - start;
        for (int i = start; i <= endX; i++) {
            ans.add(matrix[start][i]);
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                ans.add(matrix[i][endX]);
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                ans.add(matrix[endY][i]);
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                ans.add(matrix[i][start]);
            }
        }
    }
}
