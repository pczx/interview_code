package solution;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            int k = input.nextInt();
            input.nextLine();
            String phone = input.next();
            greedyCostTimes(phone.toCharArray(), n, k);
        }
    }

    public static void greedyCostTimes(char[] phone, int n, int k) {
        int minCost = Integer.MAX_VALUE;
        char[] new_phone = new char[n];
        int[] counts = new int[10];
        for (char c : phone) {
            counts[c - '0']++;
        }
        for (int cnt = 0; cnt < 10; cnt++) {
            int remaining = k - counts[cnt];
            if (remaining <= 0) {
                minCost = 0;
                new_phone = phone;
                break;
            }
            int cost = 0;
            int up = cnt + 1;
            int low = cnt - 1;
            char[] alternative_phone = Arrays.copyOf(phone, n);
            loop:
            while (remaining > 0) {
                if (up < 10) {
                    for (int i = 0; i < n; i++) {
                        if (phone[i] - '0' == up) {
                            cost += up - cnt;
                            alternative_phone[i] = (char) (cnt + '0');
                            if (--remaining == 0) {
                                break loop;
                            }
                        }
                    }
                }
                if (low >= 0) {
                    for (int i = n - 1; i >= 0; i--) {
                        if (phone[i] - '0' == low) {
                            cost += cnt - low;
                            alternative_phone[i] = (char) (cnt + '0');
                            if (--remaining == 0) {
                                break loop;
                            }
                        }
                    }
                }
                low--;
                up++;
            }
            if (cost < minCost) {
                minCost = cost;
                new_phone = alternative_phone;
            }
        }
        System.out.println(minCost);
        System.out.println(new_phone);
    }
}
