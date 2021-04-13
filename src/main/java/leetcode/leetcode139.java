package leetcode;

import java.util.List;

public class leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
