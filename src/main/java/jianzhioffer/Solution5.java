package jianzhioffer;

public class Solution5 {
    public String replaceSpace(String s) {
        int cnt = 0, n = s.length();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                cnt++;
            }
        }
        char[] arr = new char[n + 2 * cnt];
        int j = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                arr[j++] = '%';
                arr[j++] = '2';
                arr[j++] = '0';
            } else {
                arr[j++] = c;
            }
        }
        return new String(arr);
    }
}
