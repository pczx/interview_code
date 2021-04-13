package solution;

import java.util.HashMap;

public class NC28 {
    /**
     * @param S string字符串
     * @param T string字符串
     * @return string字符串
     */
    public String minWindow(String S, String T) {
        // write code here
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> target = new HashMap<>();

        for (char c : T.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int start = 0, minLen = Integer.MAX_VALUE;
        int count = 0;
        while (right < S.length()) {
            char c = S.charAt(right);
            ++right;
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.get(c))) {
                    ++count;
                }
            }
            while (count == target.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                c = S.charAt(left);
                ++left;
                if (target.containsKey(c)) {
                    if (window.get(c).equals(target.get(c))) {
                        --count;
                    }
                    window.put(c, window.get(c) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : S.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(new NC28().minWindow("XDOYEZODEYXNZ", "XYZ"));
    }
}
