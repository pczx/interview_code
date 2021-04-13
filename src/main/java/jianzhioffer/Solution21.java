package jianzhioffer;

class Solution21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quickSwap(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSwap(int[] nums, int lo, int hi) {
        int i = lo, j = hi;
        while (true) {
            while ((nums[i] & 1) == 1) {
                if (i == hi) {
                    break;
                }
                i++;
            }
            while ((nums[j] & 1) == 0) {
                if (j == lo) {
                    break;
                }
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}