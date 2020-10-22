package leetcode;

public class Solution58_I {
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder ans = new StringBuilder();

        while (i >= 0) {
            while (i >= 0 && !Character.isSpaceChar(s.charAt(i))) {
                i--;
            }
            ans.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && Character.isSpaceChar(s.charAt(i))) {
                i--;
            }
            j = i;
        }
        return ans.toString().trim();
    }
}
