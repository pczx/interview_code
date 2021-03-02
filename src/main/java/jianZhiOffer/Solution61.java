package jianZhiOffer;

import java.util.HashSet;

class Solution61 {
    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return max - min < 5;
    }
}