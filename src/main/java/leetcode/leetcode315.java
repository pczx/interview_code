package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class leetcode315 {
    int[] aux;
    int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        aux = new int[nums.length];
        ans = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }

    public void mergeSort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    public void merge(int[] nums, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];

            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                nums[k] = aux[i++];
                
            } else {
                nums[k] = aux[j++];
            }
        }
    }
}
