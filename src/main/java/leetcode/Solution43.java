package leetcode;

class Solution43 {
    public int countDigitOne(int n) {
        return recursive(n);
    }

    private int recursive(int n) {
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int last = n - high * pow;
        if (high == 1) {
            return recursive(pow - 1) + last + 1 + recursive(last);
        } else {
            return pow + high * recursive(pow - 1) + recursive(last);
        }
    }
}