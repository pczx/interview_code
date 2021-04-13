package jianzhioffer;

class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int nextUglyNumber = 1;
        int multiply2 = 0, multiply3 = 0, multiply5 = 0;
        while (nextUglyNumber < n) {
            int min = min(uglyNumbers[multiply2] * 2, uglyNumbers[multiply3] * 3, uglyNumbers[multiply5] * 5);
            uglyNumbers[nextUglyNumber] = min;

            while (uglyNumbers[multiply2] * 2 <= uglyNumbers[nextUglyNumber]) {
                multiply2++;
            }

            while (uglyNumbers[multiply3] * 3 <= uglyNumbers[nextUglyNumber]) {
                multiply3++;
            }

            while (uglyNumbers[multiply5] * 5 <= uglyNumbers[nextUglyNumber]) {
                multiply5++;
            }
            nextUglyNumber++;
        }
        return uglyNumbers[n - 1];
    }


    private int min(int number1, int number2, int number3) {
        int min = Math.min(number1, number2);
        return Math.min(min, number3);
    }
}