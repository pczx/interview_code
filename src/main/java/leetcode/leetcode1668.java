package leetcode;

public class leetcode1668 {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() <= sequence.length()) {
            sb.append(word);
            if(sequence.contains(sb.toString())) {
                ans++;
            }
        }
        return ans;
    }
}
