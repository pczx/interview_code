package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class leetcode473 {

    private List<Integer> nums;
    private int[] sums;
    private int possibleSquareSide;

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int possibleSquareSide = sum / 4;
        if (possibleSquareSide * 4 != sum) {
            return false;
        }
        this.sums = new int[4];
        this.possibleSquareSide = possibleSquareSide;
        this.nums = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return dfs(0);
    }

    private boolean dfs(int index) {
        if (index == nums.size()) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        int element = this.nums.get(index);

        for (int i = 0; i < 4; i++) {
            this.sums[i] += element;
            if (this.sums[i] <= this.possibleSquareSide) {
                if (dfs(index + 1)) {
                    return true;
                }
            }
            this.sums[i] -= element;
        }

        return false;
    }
}
