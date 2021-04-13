package leetcode;

public class leetcode190 {
    public int reverseBits(int n) {
        int ans = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
           bits[i] = (n >> i) & 1;
        }
        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i] > 0) {
                ans |= 1 << (bits.length - 1 - i);
            };
        }
        return ans;
    }
}
