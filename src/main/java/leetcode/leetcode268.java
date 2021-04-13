package leetcode;

import java.util.Arrays;

public class leetcode268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (mid == nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
