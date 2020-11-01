package leetcode;

class Solution53_I {
    public int search(int[] nums, int target) {
        int number = 0;
        if (nums != null && nums.length > 0) {
            int first = getFirstK(nums, target);
            int last = getLastK(nums, target);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }

    public int getFirstK(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int midData = nums[mid];
            if (midData == k) {
                if ((mid > 0 && nums[mid - 1] != k) || mid == 0) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (midData > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int getLastK(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int midData = nums[mid];
            if (midData == k) {
                if ((mid < nums.length - 1 && nums[mid + 1] != k) || mid == nums.length - 1) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (midData > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        new Solution53_I().search(arr, 8);
    }
}