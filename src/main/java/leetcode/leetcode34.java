package leetcode;

import java.util.Arrays;

public class leetcode34 {
//    public int[] searchRange(int[] nums, int target) {
//
//    }

    public int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) >> 1;
            if (nums[mid] < target) {
                i = mid + 1 ;
            } else {
                j = mid;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode34().binarySearch(new int[]{1}, 2));
    }
}
