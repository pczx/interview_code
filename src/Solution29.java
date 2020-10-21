import java.util.ArrayList;

public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix[0].length == 0) {
            return ans.stream().mapToInt(i -> i).toArray();
        }

        int y1 = 0;
        int y2 = matrix.length - 1;
        int x1 = 0;
        int x2 = matrix[0].length - 1;


        while (x1 <= x2 && y1 <= y2) {
            for (int i = x1; i <= x2; i++) {
                ans.add(matrix[y1][i]);
            }

            for (int i = y1 + 1; i <= y2; i++) {
                ans.add(matrix[i][x2]);
            }

            if (y1 != y2) {
                for (int i = x2 - 1; i >= x1; i--) {
                    ans.add(matrix[y2][i]);
                }
            }

            if (x1 != x2) {
                //下 -> 上
                for (int i = y2 - 1; i > y1 + 1; i--) {
                    ans.add(matrix[i][x1]);
                }
            }
            x1++;
            x2--;
            y1++;
            y2--;
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
