package leetcode;

class Solution53_I {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target) - binarySearch(nums, target - 1);
    }

    public int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                i++;
            }
        }
        return i;
    }
}