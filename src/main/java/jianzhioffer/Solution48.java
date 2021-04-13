package jianzhioffer;

import java.util.HashMap;

class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        int curLength = 0;
        int maxLength = 0;

        int[] position = new int[26];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) || (i - map.get(s.charAt(i)) > curLength)) {
                curLength++;
            } else {
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = i - map.get(s.charAt(i));
            }
            map.put(s.charAt(i), i);
        }

        if (curLength > maxLength) {
            maxLength = curLength;
        }
        return maxLength;
    }
}