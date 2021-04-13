package jianzhioffer;

public class Solution51 {

    private int[] aux;
    private int result;

    public int reversePairs(int[] nums) {
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return result;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) >> 1;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                result += mid - i + 1;
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }
}
