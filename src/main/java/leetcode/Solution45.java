package leetcode;

import java.util.Arrays;

class Solution45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(s);
        }
        return result.toString();
    }
}