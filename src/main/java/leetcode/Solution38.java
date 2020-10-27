package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution38 {

    private List<String> result = new ArrayList<>();

    private char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        permutation(0);
        return result.toArray(new String[0]);
    }

    private void permutation(int x) {
        if (x == chars.length - 1) {
            result.add(new String(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(i, x);
            permutation(x + 1);
            swap(i, x);
        }
    }

    private void swap(int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}