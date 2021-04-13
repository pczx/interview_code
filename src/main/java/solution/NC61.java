package solution;

import java.util.Arrays;
import java.util.HashMap;

public class NC61 {
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            if (map.containsKey(target - value)) {
                Integer index = map.get(target - value);
                int[] ans = new int[]{i + 1, index + 1};
                Arrays.sort(ans);
                return ans;
            }
            map.put(value, i);
        }
        return new int[2];
    }
}
