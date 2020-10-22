package leetcode;

class Solution21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quickSwap(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSwap(int[] nums, int low, int high) {
        int i = low, j = high;
        while (i < j) {
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            while (i < j && nums[i  ] % 2 != 0) {
                i++;
            }
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}