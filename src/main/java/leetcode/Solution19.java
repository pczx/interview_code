package leetcode;

class Solution19 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return isMatchCore(s, 0, p, 0);
    }

    private boolean isMatchCore(String str, int strIndex, String pattern, int patternIndex) {
        if (strIndex == str.length() && patternIndex == pattern.length()) {
            return true;
        }

        if (strIndex != str.length() && patternIndex == pattern.length()) {
            return false;
        }

        if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
            if ((strIndex != str.length() && pattern.charAt(patternIndex) == str.charAt(strIndex)) || (pattern.charAt(patternIndex) == '.' && strIndex != str.length())) {
                return isMatchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        || isMatchCore(str, strIndex + 1, pattern, patternIndex)
                        || isMatchCore(str, strIndex, pattern, patternIndex + 2);
            } else {
                return isMatchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        if ((strIndex != str.length() && pattern.charAt(patternIndex) == str.charAt(strIndex)) || (pattern.charAt(patternIndex) == '.' && strIndex != str.length())) {
            return isMatchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}