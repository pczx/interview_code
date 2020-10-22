package sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void sort(int[] a) {
        int n = a.length;

        int h = 1;
        while (3 * h < n) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    int temp = a[j - h];
                    a[j - h] = a[j];
                    a[j] = temp;
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 6, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
