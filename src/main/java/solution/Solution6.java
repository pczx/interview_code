package solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution6 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            in.nextLine();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0, j = n - 1; i < n / 2; i++, j--) {
                min = Math.min(min, nums[i] + nums[j]);
                max = Math.max(max, nums[i] + nums[j]);
            }
            System.out.println(max - min);
        }
    }
}
