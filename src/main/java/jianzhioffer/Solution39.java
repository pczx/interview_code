package jianzhioffer;

class Solution39 {
    public int majorityElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = nums.length >> 1;
        int index = partition(nums, start, end);
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
                index = partition(nums, start, end);
            }

            if (index < mid) {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        int result = nums[mid];
        return checkMoreThanHalf(nums, result) ? result : 0;
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi;
        int tmp = a[lo];
        while (i < j) {
            while (i < j && a[j] > tmp)
                j--;
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && a[i] < tmp)
                i++;
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = tmp;
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean checkMoreThanHalf(int[] a, int number) {
        int times = 0;
        for (int n : a) {
            if (number == n) {
                times++;
            }
        }
        return times > a.length / 2;
    }
}