public class Solution10_2 {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2, c = 0;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }
}
