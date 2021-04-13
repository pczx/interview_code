package jianzhioffer;

class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] ans = new int[k];
        int start = 0, end = arr.length - 1;
        int index = partition(arr, start, end);
        while (index != k - 1) {
            if (index > k -1) {
                end = index - 1;
                index = partition(arr, start, end);
            } else {
                start = index + 1;
                index = partition(arr, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    private int partition(int[] a, int i, int j) {
        int temp = a[i];
        while (i < j) {
            while (i < j && a[j] > temp) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && a[i] < temp) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = temp;
        return i;
    }
}

