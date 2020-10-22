package leetcode;

class Solution39 {
    public int majorityElement(int[] nums) {
        int x = 0, vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                x = num;
            }
            //正负抵消
            vote += x == num ? 1 : -1;
        }

        //验证
        int count = 0;
        for (int num : nums) {
            if (x == num) {
                count++;
            }
        }
        return count > nums.length / 2 ? x : 0;
    }
}