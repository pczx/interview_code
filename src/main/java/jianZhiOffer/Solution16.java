package jianZhiOffer;

class Solution16 {
    public double myPow(double x, int n) {
        if (x == 0.0 && n < 0) {
            return 0.0;
        }

        long absN = n;
        if (n < 0) {
            absN = -absN;
        }
//        double result = powerOfUnsignedExponentRecursively(x, absN);
        double result = powerOfUnsignedExponent(x, absN);

        if (n < 0) {
            result = 1.0 / result;
        }
        return result;
    }


    //非递归版本
    public double powerOfUnsignedExponent(double base, long exponent) {
        double result = 1.0;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }


    //递归版本
    public double powerOfUnsignedExponentRecursively(double base, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerOfUnsignedExponentRecursively(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }
}