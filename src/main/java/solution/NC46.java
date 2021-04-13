package solution;

import java.util.ArrayList;
import java.util.Arrays;

public class NC46 {

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    ArrayList<Integer> cnt = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        dfs(num, 0, target);
        return ans;
    }

    private void dfs(int[] num, int index, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(cnt));
            return;
        }
        if (index == num.length) {
            return;
        }
        for (int i = index; i < num.length; i++) {
            if (i > index && num[i] == num[i - 1]) {
                continue;
            }
            if (target >= num[i]) {
                cnt.add(num[i]);
                dfs(num, i + 1, target - num[i]);
                cnt.remove(cnt.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new NC46().combinationSum2(new int[]{100, 10, 20, 70, 60, 10, 50}, 80);
        System.out.println(arrayLists);
    }
}
