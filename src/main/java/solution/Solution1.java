package solution;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            input.nextLine();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = input.nextInt();
            }
            Arrays.sort(nums);
            long m1 = (long) nums[0] * nums[1] * nums[n - 1];
            long m2 = (long) nums[n - 3] * nums[n - 2] * nums[n - 1];
            System.out.println(Math.max(m1, m2));
        }
    }
}
