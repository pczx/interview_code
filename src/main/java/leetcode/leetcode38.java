package leetcode;

public class leetcode38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for (int j = i; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    sb.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
                sb.append(count).append(pre);
                str = sb.toString();
            }
        }
        return str;
    }

    public static void main(String[] args) {

    }
}
