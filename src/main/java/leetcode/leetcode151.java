package leetcode;

public class leetcode151 {

    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            j = i;
            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }
            i = j;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            i = j;
            ans.append(s.substring(j + 1, i + 1)).append(" ");
        }
        return ans.toString().trim();
    }

}
