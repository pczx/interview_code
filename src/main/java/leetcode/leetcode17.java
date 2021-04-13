package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode17 {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        dfs(ans, phoneMap, 0, digits, new StringBuilder());
        return ans;
    }

    private void dfs(List<String> ans, Map<Character, String> phoneMap, int index, String digits, StringBuilder sb) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(ans, phoneMap, index + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
