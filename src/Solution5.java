public class Solution5 {
    public String replaceSpace(String s) {
        int cnt = 0, n = s.length();
        for (char c : s.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                cnt++;
            }
        }
        char[] newArr = new char[n + 2 * cnt];
        int j = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isSpaceChar(c)) {
                newArr[j++] = '%';
                newArr[j++] = '2';
                newArr[j++] = '0';
            } else {
                newArr[j++] = c;
            }
        }
        return new String(newArr);
    }
}
