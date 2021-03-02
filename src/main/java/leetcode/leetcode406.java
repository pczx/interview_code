package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] people1, int[] people2) {
                if (people1[0] != people2[0]) {
                    return people1[0] - people2[0];
                } else {
                    return people2[1] - people1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int space = person[1];
            for (int i = 0; i < n; i++) {
                if (ans[i] == null) {
                    if (space-- == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
