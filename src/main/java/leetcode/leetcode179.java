package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode179 {
    public String largestNumber(int[] nums) {
        String[] a = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(a, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        return String.join("", a);
    }
}
