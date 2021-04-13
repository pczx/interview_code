package leetcode;

public class leetcode896 {
    public boolean isMonotonic(int[] A) {
        boolean isAsc = true, isDesc = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                isAsc = false;
            }
            if (A[i] < A[i + 1]) {
                isDesc = false;
            }
        }
        return isAsc || isDesc;
    }
}
