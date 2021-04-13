package leetcode;

public class leetcode65 {

    int index = 0;

    public boolean isNumber(String s) {
        s = s.trim();
        boolean numeric = scanInteger(s);
        if (index < s.length() && s.charAt(index) == '.') {
            index++;
            numeric = scanUnsignedInteger(s) || numeric;
        }

        if (index < s.length() && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            index++;
            numeric = numeric && scanInteger(s);
        }

        return numeric && index == s.length();
    }

    public boolean scanUnsignedInteger(String s) {
        int before = index;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            index++;
        }
        return index > before;
    }

    public boolean scanInteger(String s) {
        while (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            index++;
        }
        return scanUnsignedInteger(s);
    }

    public static void main(String[] args) {
        System.out.println(new leetcode65().isNumber("-1."));
    }
}
