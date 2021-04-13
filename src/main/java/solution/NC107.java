package solution;

public class NC107 {
    public int solve(int[] a) {
        // write code here
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            int l = Math.max(i - 1, 0);
            int r = Math.min(i + 1, a.length - 1);
            if (a[l] <= a[i] && a[i] >= a[r]) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }
}
