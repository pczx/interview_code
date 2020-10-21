import java.util.ArrayList;
import java.util.Arrays;

class Solution17 {

    ArrayList<Integer> ans = new ArrayList<>();

    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        char[] numbers = new char[n];
        recursive(numbers, 0);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void recursive(char[] arr, int index) {
        if (index == arr.length) {
            save(arr);
            return;
        }

        for (int i = 0; i < 10; i++) {
            arr[index] = (char)(i + '0');
            recursive(arr, index + 1);
        }
    }


    public int[] printNumbers2(int n) {
        if (n <= 0) {
            return new int[0];
        }
        char[] numbers = new char[n];
        Arrays.fill(numbers, '0');
        while (!increment(numbers)) {
            save(numbers);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }


    private boolean increment(char[] arr) {
        boolean isOverFlow = false;
        int carry = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int nSum = arr[i] - '0' + carry;
            if (i == arr.length - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    nSum -= 10;
                    carry = 1;
                    arr[i] = (char)('0' + nSum);
                }
            } else {
                arr[i] = (char)('0' + nSum);
                break;
            }
        }
        return isOverFlow;
    }



    private void save(char[] arr) {
        int index = -1;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
           if (arr[i] != '0') {
               index = i;
               break;
           }
        }
        if (index != -1) {
            ans.add(Integer.parseInt(new String(arr, index, size - index)));
        }
    }
}