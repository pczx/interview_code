public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (++count[nums[i]] > 1) {
                return nums[i];
            }
        }
        return 0;
    }
}
