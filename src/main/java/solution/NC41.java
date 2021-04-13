package solution;


import java.util.HashMap;
import java.util.HashSet;

public class NC41 {
    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int start = 0, end = 0; end < arr.length; end++) {
            if (map.containsKey(arr[end])) {
                start = map.get(arr[end]) + 1;
            }
            ans = Math.max(ans, end - start + 1);
            map.put(arr[end], end);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NC41().maxLength(new int[]{2, 2, 3, 4, 3}));
    }
}
