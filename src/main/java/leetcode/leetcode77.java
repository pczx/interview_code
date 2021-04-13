package leetcode;

import java.util.ArrayList;
import java.util.List;

class leetcode77 {

    private List<List<Integer>> ans = new ArrayList<>();

    private List<Integer> cnt = new ArrayList<>();

    private int k;

    private int n;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        dfs(1);
        return ans;
    }

    public void dfs(int index) {
        if (cnt.size() == k) {
            ans.add(new ArrayList<>(cnt));
            return;
        }

        for (int i = index; i <= n; i++) {
            cnt.add(i);
            dfs(i + 1);
            cnt.remove(cnt.size() - 1);
        }
    }

    public static void main(String[] args) {
        new leetcode77().combine(4, 2);
    }
}