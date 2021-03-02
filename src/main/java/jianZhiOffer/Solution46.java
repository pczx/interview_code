package jianZhiOffer;

class Solution46 {
    public int translateNum(int num) {
        if (num < 0) {
            return 0;
        }
        return translateNum(String.valueOf(num));
    }

    private int translateNum(String number) {
        int length = number.length();
        int[] counts = new int[length];
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            count = 0;
            if (i < length - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }
            if (i < length - 1) {
                int digit1 = number.charAt(i) - '0';
                int digit2 = number.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < length - 2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }

            }
            counts[i] = count;
        }
        count = counts[0];
        return count;
    }
}