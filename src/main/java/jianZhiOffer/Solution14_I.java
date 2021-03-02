package jianZhiOffer;

public class Solution14_I {
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                products[i] = Math.max(products[i], products[j] * products[i - j]);
            }
        }
        return products[n];
    }
}
