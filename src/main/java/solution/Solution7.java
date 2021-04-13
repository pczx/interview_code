package solution;

import java.util.*;


public class Solution7 {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    /**
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public int[] getMinStack (int[][] op) {
        // write code here
        List<Integer> mins = new ArrayList<>();
        for (int[] o : op) {
            if (o[0] == 1) {
                data.push(o[1]);
                if (min.isEmpty() || o[1] <= min.peek()) {
                    min.push(o[1]);
                }
            } else if (o[0] == 2) {
                int value = data.pop();
                if (value == min.peek()) {
                    min.pop();
                }
            } else if (o[0] == 3) {
                mins.add(min.peek());
            }
        }
        int[] ans = new int[mins.size()];
        for (int i = 0; i < mins.size(); i++) {
            ans[i] = mins.get(i);
        }
        return ans;
    }
}