package solution;

import java.util.Arrays;

public class NC22 {
    public void merge(int A[], int m, int B[], int n) {
        int[] ans = Arrays.copyOf(A, m + n);
        int i = 0, j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i == m) {
                ans[k] = B[j++];
            } else if (j == n) {
                ans[k] = A[i++];
            } else if (A[i] < B[j]) {
                ans[k] = A[i++];
            } else {
                ans[k] = B[j++];
            }
        }
        System.arraycopy(ans, 0, A, 0, m + n);
    }
}
