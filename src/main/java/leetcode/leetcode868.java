package leetcode;

public class leetcode868 {
    public int binaryGap(int n) {
        int ans = 0, last = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) > 0) {
                ans = Math.max(ans, i - last);
                last = i;
            }
        }
        return ans;
    }
}
