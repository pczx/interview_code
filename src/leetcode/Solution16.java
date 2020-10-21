package leetcode;

class Solution16 {
    public double myPow(double x, int n) {
        if (x == 0.0 && n < 0) {
            return 0.0;
        }

        long absExponent = n;
        if (n < 0) {
            absExponent = -absExponent;
        }
        double result = powerOfUnsignedExponent(x, absExponent);
        if (n < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    public double powerOfUnsignedExponent(double base, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerOfUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }
}