package leetcode;

class Solution53_II {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] != mid) {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        if (left == nums.length) {
            return nums.length;
        }
        return -1;
    }
}