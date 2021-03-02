package jianZhiOffer;

public class Solution20 {

    private int index = 0;

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        while (index != s.length() && s.charAt(index) == ' ') {
            index++;
        }

        boolean numeric = scanInteger(s);

        if (index != s.length() && s.charAt(index) == '.') {
            index++;
            numeric = scanUnsignedInteger(s) || numeric;
        }

        if (index != s.length() && (s.charAt(index) == 'E' || s.charAt(index) == 'e')) {
            index++;
            numeric = numeric && scanInteger(s);
        }

        while (index != s.length() && s.charAt(index) == ' ')
            index++;

        return numeric && index == s.length();
    }

    private boolean scanInteger(String str) {
        if (index != str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(String str) {
        int before = index;
        while (index != str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            index++;
        }
        return index > before;
    }
}
