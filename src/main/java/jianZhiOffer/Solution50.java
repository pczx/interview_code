package jianZhiOffer;

class Solution50 {
    public char firstUniqChar(String s) {
        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        for (char c : s.toCharArray()) {
            if (counts[c] == 1) {
                return c;
            }
        }
        return ' ';
    }
}