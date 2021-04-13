package jianzhioffer;

class Solution44 {
    public int findNthDigit(int n) {
        if (n < 0) {
            return -1;
        }
        int digits = 1;
        while (true) {
            long numbers = countOfInteger(digits);
            if (n < numbers * digits) {
                return digitAtIndex(n, digits);
            }
            n -= numbers * digits;
            digits++;
        }
    }

    private int digitAtIndex(long n, int digits) {
        long number = beginNumber(digits) + n / digits;
        long indexFromRight = digits - n % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        number %= 10;
        return (int) number;
    }

    private long beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }
        return (long) Math.pow(10, digits - 1);
    }

    private long countOfInteger(int digits) {
        if (digits == 1) {
            return 10;
        }
        return 9 * (long) Math.pow(10, digits - 1);
    }
}